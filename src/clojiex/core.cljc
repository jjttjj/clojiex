(ns clojiex.core
  (:refer-clojure :exclude [get])
  (:require
   [clojure.string :as str]
   [clojure.spec.alpha :as s]
   #?@(:clj
       [[cheshire.core :as json]
        [clj-http.client :as http]
        [clojure.java.io :as io]]
       :cljs [[goog.net.XhrIo :as xhr]]))
  #?(:clj (:import [java.io InputStream])))

(defn param-str [param-map]
  (str "?" (str/join "&" (map (fn [[k v]] (str (name k) "=" v)) param-map))))

(defn endpoint-str
  ([client segs qmap]
   (endpoint-str client segs qmap false))
  ([client segs qmap sse?]
   (str
    ((if sse? :sse-url-base :url-base) client) "/"
    (:version client) "/"
    (str/join "/" (map name segs))
    (param-str (assoc qmap :token (:token client))))))

(defn get [client segs qmap cb]
  #?(:clj
     (http/get (endpoint-str client segs qmap)
               {:cookie-policy :standard
                :async?        true}
               #(-> % :body (json/parse-string true) cb)
               #(throw %))
     :cljs
     (xhr/send (endpoint-str client segs qmap)
               (fn [e]
                 (-> (.-target e)
                     .getResponseJson
                     (js->clj :keywordize-keys true)
                     cb)))))

#?(:clj (def event-mask (re-pattern (str "(?s).+?\r\n\r\n"))))

#?(:clj
   (defn- parse-event [raw-event]
     (->> (re-seq #"(.*): (.*)\n?" raw-event)
          (map rest)
          (group-by first)
          (reduce (fn [acc [k v]]
                    (assoc acc (keyword k) (str/join (map second v)))) {}))))

;;from:
;;https://gist.github.com/oliyh/2b9b9107e7e7e12d4a60e79a19d056ee
#?(:clj
   (defn event-source [url cb & [params]]
     (let [^InputStream event-stream
           (:body (http/get url (merge params {:as :stream})))]
       (future
         (loop [data nil]
           (let [byte-array (byte-array (max 1 (.available event-stream)))
                 bytes-read (.read event-stream byte-array)]
             (if (neg? bytes-read)
               ;;Input stream closed, exit read-loop
               (.close event-stream)
               (let [data (str data (slurp byte-array))]
                 (if-let [es (not-empty (re-seq event-mask data))]
                   (if (every? not-empty
                               (map (fn [x]
                                      (doto (parse-event x) cb))
                                    es))
                     (recur (str/replace data event-mask ""))
                     ;;Output stream closed, exiting read-loop
                     (.close event-stream))

                   (recur data)))))))
       
       event-stream)))

(defn stream [client segs qmap cb]
  #?(:clj
     (event-source (endpoint-str client segs qmap true)
                   (fn [x]
                     (let [msg
                           (reduce-kv (fn [m k v]
                                        (assoc m k (json/parse-string v true)))
                                      {} x)]
                       #_
                       (when (not-empty (dissoc msg :data))
                         (log/warn "Non :data key in event source message"))
                       (some-> msg :data first cb))))
     :cljs
     (let [es (js/EventSource. (endpoint-str client segs qmap true))]
       (set! (.-onmessage es)
             (fn [e]
               (some-> e
                       .-data
                       js/JSON.parse
                       (js->clj :keywordize-keys true)
                       first
                       cb)))
       es)))

(defn close [event-source]
  (.close event-source))
