(ns dev
  (:require [dev.jt.clojiex :as iex]))

(def client
  {:url-base     "https://sandbox.iexapis.com"
   :sse-url-base "https://sandbox-sse.iexapis.com"
   :version      "stable"
   :token        "<iex pub token>"})

;;synchronous calls, without callback, work in clojure only
(def historical-bars
  (iex/get client [:stock/chart {:symbol "SPY" :range "1m"}]))

;;async call works in clojure and clojurescript
(iex/get client [:stock/chart {:symbol "SPY" :range "1m"}] println)

;;start streaming data
(def st (iex/sse client [:tops {:symbols "SPY"}] #(prn "stream value " %)))

;;close stream
(iex/close st)
