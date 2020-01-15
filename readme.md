# clojiex 

A very lightweight Clojure wrapper for [IEX Cloud](https://iexcloud.io/docs/api/). 

Works in both clojure and clojurescript. 

Supports single requests as well as streaming via Server Sent Events.

Subject to change.

# termonology


| term      | form                                                                                                                       |
|-----------|----------------------------------------------------------------------------------------------------------------------------|
| client    | A map containing the keys `:version`, `:url-base`, `:sse-url-base` and `token`.                                            |
| request   | `[<segment>+ <query-map>?]` eg `[:stock "SPY" :chart]` or `[:stock "SPY" :chart {:range "1y"}]`                            |
| segment   | A keyword or string. Turns into a path parameter. The combined segments correspond to the IEX api endpoint                 |
| query-map | A map which turns into query parameters for the endpoint.                                                                  |
| callback  | A function to run on receiving data. Is called once on the result of a `get` request and on each new value from a `stream` |                                               |

# Examples

For a list of available endpoints, see the [IEX docs](https://iexcloud.io/docs/api/). 

You will need an api token. [Sign up for IEX Cloud](https://iexcloud.io/s/6292bbcc) to get one. This is a referral link. You don't need to provide any payment information to sign up and get an api token you can start using. Just an email and password. You get a decent amount of free data each month and unlimited sandbox api usage.

```clojure
;;Add git dependency to deps.edn
clojiex {:git/url "https://github.com/jjttjj/clojiex.git"
         :sha     "921306e9b7ce595c35cc73e56d97f5d5a8e64d74"}
```

```clojure

(require '[clojiex.core :as iex])

```

First define a client.

```clojure
(def iex-client
  {:version      "stable"
   :url-base     "https://sandbox.iexapis.com"
   :sse-url-base "https://sandbox-sse.iexapis.com"
   :token        "<your IEX pub token>"})
```

`clojiex.core/get` takes a client, a request and a callback function to run on the resulting data.

```clojure
(iex/get iex-client
         [:stock "SPY" :chart] ;;represents "GET /stock/SPY/chart/"
         {:range "1m"}
         prn)
```


You can stream via SSE with the `clojiex.core/stream` function, which also takes a request and a callback to run on each result: 

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
