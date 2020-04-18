# clojiex 

A very lightweight Clojure wrapper for [IEX Cloud](https://iexcloud.io/docs/api/). 

Works in both clojure and clojurescript. 

Supports single requests as well as streaming via Server Sent Events.

Subject to change.

For a list of available endpoints, see the [IEX docs](https://iexcloud.io/docs/api/). 

You will need an api token. [Sign up for IEX Cloud](https://iexcloud.io/s/6292bbcc) to get one. This is a referral link. You don't need to provide any payment information to sign up and get an api token you can start using. Just an email and password. You get a decent amount of free data each month and unlimited sandbox api usage.

# termonology

| term         | form                                                                                                                       |
|--------------|----------------------------------------------------------------------------------------------------------------------------|
| client       | A map containing the keys `:version`, `:url-base`, `:sse-url-base` and `token`.                                            |
| request      | `[endpoint-key arg-map]` eg. `[:stock/chart {:symbol "SPY" :range "1y"}]` |
| endpoint-key | A keyword which correspond to an IEX api endpoint with all path params removed. Path params should instead be provided in the `arg-map`, using a keyword name which corresponds to the path param name used in the iex documentation.                  |
| arg-map | A map of keyword names to values, containing all path and query params for the request.|
| callback  | A function to run on received data. Is called once on the result of a `get` request and on each new value from a `sse`. Note: callbacks are optional for `get` requests on clojure. Omitting it will synchronously return the result. On clojurescript they are requred. |

# Examples

```clojure
;;Add git dependency to deps.edn
clojiex {:git/url "https://github.com/jjttjj/clojiex.git"
         :sha     "<latest git sha for this project>"}
```

```clojure
(ns dev
  (:require [dev.jt.clojiex :as iex]))

(def iex-version "stable")

(def pub-token "<pub-token>")
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

```

# TODO 

- [ ] error handling
- [ ] logging
- [ ] POST requests (account data)

# License

Copyright © Justin Tirrell

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version. https://opensource.org/licenses/EPL-1.0
