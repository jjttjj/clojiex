(ns parse
  "This namespace takes the IEX documentation html and gererates a map of op keys to path segments, with path params replaced by keyword names"
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [zprint.core :as zp]
            [clojure.java.io :as io]

            [clojure.repl :refer :all]
            [clojure.pprint :refer :all]
            [clojure.set :as set])
  (:import org.jsoup.Jsoup))


;;Clojiex needs to know what paremters belong in a path so that it can extract
;;them from the arg-map passed in a clojiex request.

;;Here we attempt to parse the IEX docs to extract the path parameters for each
;;endpoint. We use two seperate techniques and merge the results together. We
;;are not aiming for pefection at this point, the goal is to just capture a
;;decent majority.

(defn ->kw-param-seg
  "Takes a string path segment and returns a keyword if it is a path
  param (denoted in the iex docs by being enclosed in curly braces)."
  [seg]
  (if (string? seg)
    (let [[_ brak qmark1 nm qmark2] (re-find #"(\{)?(\?)?([^}?]+)(\?)?\}?" seg)]
      (if brak
        (keyword nm)
        nm))
    seg))

(defn number->eventType
  "Takes a string path segment and replaces integers with :eventType (which is
  what integers (seemingly always?) represent in path segments in the iex docs."
  [seg]
  (if (and (string? seg) (re-matches #"^[0-9]+$" seg))
    :eventType
    seg))

(defn handle-seg
  "Takes a string path segment. If it represents a path parameter return a keyword
  representing the paramter name. Otherwise return the string unchanged."
  [seg]
  (-> seg ->kw-param-seg number->eventType))

(defn segs->op
  "Takes a sequence of url path segments with path parameters represented as
  keywords and returns a keyword representing the name of the operation"
  [segs]
  (let [static (filter string? segs)
        qual   (butlast static)
        op     (keyword (when qual (str/join "." qual)) (last static))]
    op))


;;Looks for endpoints in the "HTTP REQUEST" example codeblocks
(defn op->segs
  "Takes a file and returns a map of op keywords to a vector of path segments,
  with path params as kewords"
  [file]
  (let [doc-str (slurp file)
        jsoup   (Jsoup/parse doc-str)]
    (->>
      ;;this jsoup path has the GET example usage
      (.select jsoup ".highlight.shell.tab-shell")
      (map #(.text %))
      (filter #(re-find #"^GET " %))

      ;;some examples have multiple get lines
      (mapcat #(re-seq #"(?m)GET.+$" %))

      ;;split into segment strings
      (map #(str/split % #"/"))

      ;;drop "GET"
      (map #(drop 1 %))

      ;;We replace "{x}" or "{x?}" with :x and "1" or any digit with :event-type
      ;;Only keep thinkgs with at least one keyword segment.
      (keep (fn [segs]
              (let [kw-segs (mapv handle-seg segs)]
                (when (some keyword? kw-segs)
                  [(segs->op kw-segs) kw-segs]))))
      (into {}))))

;;Looks for endpoints in code strings typically under "Available Methods"
(defn op->segs2
  "Takes a file and returns a map of op keywords to a vector of path segments,
  with path params as kewords"
  [file]
  (let [doc-str (slurp file)
        jsoup   (Jsoup/parse doc-str)]
    (->>
      ;;this jsoup path has the GET example usage
      (.select jsoup "p code.prettyprint")
      (map #(.text %))
      (filter #(re-find #"^/" %))
      (map #(str/split % #"/"))

      ;;remove empty string
      (map #(drop 1 %))

      (keep (fn [segs]
              (let [kw-segs (mapv handle-seg segs)]
                (when (some keyword? kw-segs)
                  [(segs->op kw-segs) kw-segs]))))
      (into {})

      ;;i believe it's fine to 'dedupe' the keys by inserting into map here.
      ;; (group-by identity)
      ;; (filter (fn [[_ xs]] (> (count xs) 1)) )
      ;; (map second)
      
      )))

;;spit an edn file to be used in path_params.cljc
(comment
  (spit "data.edn"
    (zp/zprint-str
      (merge
        (op->segs (io/resource "iex-docs-2020-04-15.html"))
        (op->segs2 (io/resource "iex-docs-2020-04-15.html")))
      80
      {:map {:comma? false}})))

(comment
  (require '[clojure.set :as set])

  (set/difference
    (set (keys (op->segs (io/resource "iex-docs-2020-04-15.html"))))
    (set (keys (op->segs2 (io/resource "iex-docs-2020-04-15.html"))))))


