(ns dev
  (:require [dev.jt.clojiex :as iex]))

(def iex-version "stable")

(def pub-token "<iex pub token>")
(def iex-base "https://sandbox.iexapis.com")
(def iex-sse-base "https://sandbox-sse.iexapis.com")

(def client
  {:url-base     iex-base
   :sse-url-base iex-sse-base
   :version      iex-version
   :token        pub-token})

;;synchronous calls, without callback, work in clojure only
(def historical-bars
  (iex/get client [:stock/chart {:symbol "SPY" :range "1m"}]))

;;async call works in clojure and clojurescript
(iex/get client [:stock/chart {:symbol "SPY" :range "1m"}] println)

;;start streaming data
(def st (iex/sse client [:tops {:symbols "SPY"}] #(prn "stream value " %)))

;;close stream
(iex/close st)
