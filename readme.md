# clojiex 

A very lightweight Clojure wrapper for [IEX Cloud](https://iexcloud.io/s/6292bbcc) (referral link). 

Works in both clojure and clojurescript. 

Supports single requests as well as streaming via Server Sent Events.

Subject to change.

# Usage

```
;;Add git dependency to deps.edn
clojiex {:git/url "https://github.com/jjttjj/clojiex.git"
         :sha     "921306e9b7ce595c35cc73e56d97f5d5a8e64d74"}
```

```clojure

(require '[clojiex.core :as iex])

```


A "client" is just a map containing the following keys

```clojure
(def iex-client
  {:version      "stable"
   :url-base     "https://sandbox.iexapis.com"
   :sse-url-base "https://sandbox-sse.iexapis.com"
   :token        "<your IEX pub token>"})
```

`clojiex.core/get` takes a client, a vector of URL segments which correspond a GET endpoint in the iex api (you can use keywords or strings for each segment) a map of query params, and a callback function to run on the resulting data.

```clojure
(iex/get iex-client
         [:stock "SPY" :chart] ;;represents "GET /stock/SPY/chart/"
         {:range "1m"}
         prn)
```


You can stream via SSE with the `clojiex.core/stream` function, which also takes a vector of segments, a query param map and a callback to run on each result: 

```clojure
(def ticker (iex/stream
             iex-client
             [:TOPS]
             {:symbols "SPY"}
             #(prn "new server sent event:" %)))

;;call close to stop the stream
(iex/close ticker)

```

# TODO 

- [ ] error handling
- [ ] logging
- [ ] POST requests (account data)

# License

Copyright © Justin Tirrell

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version. https://opensource.org/licenses/EPL-1.0
