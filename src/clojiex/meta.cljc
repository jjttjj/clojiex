(ns clojiex.meta)

(def op->kw-segs
  {:crypto/price                  ["crypto" :symbol "price"]
   :crypto/quote                  ["crypto" :symbol "quote"]
   :data-points/market            ["data-points" "market" :symbol]
   :ref-data.exchange/symbols     ["ref-data" "exchange" :exchange "symbols"]
   :ref-data.us/dates             ["ref-data" "us" "dates" :type :direction :last :startDate]
   :search                        ["search" :fragment]
   :stock.market/list             ["stock" "market" "list" :list-type]
   :stock.news/last               ["stock" :symbol "news" "last" :last]
   :stock/advanced-stats          ["stock" :symbol "advanced-stats"]
   :stock/book                    ["stock" :symbol "book"]
   :stock/ceo-compensation        ["stock" :symbol "ceo-compensation"]
   :stock/chart                   ["stock" :symbol "chart" :range :date]
   :stock/delayed-quote           ["stock" :symbol "delayed-quote"]
   :stock/dividends               ["stock" :symbol "dividends" :range]
   :stock/earnings                ["stock" :symbol "earnings" :last :field]
   :stock/estimates               ["stock" :symbol "estimates"]
   :stock/fund-ownership          ["stock" :symbol "fund-ownership"]
   :stock/insider-roster          ["stock" :symbol "insider-roster"]
   :stock/insider-summary         ["stock" :symbol "insider-summary"]
   :stock/insider-transactions    ["stock" :symbol "insider-transactions"]
   :stock/institutional-ownership ["stock" :symbol "institutional-ownership"]
   :stock/intraday-prices         ["stock" :symbol "intraday-prices"]
   :stock/largest-trades          ["stock" :symbol "largest-trades"]
   :stock/logo                    ["stock" :symbol "logo"]
   :stock/ohlc                    ["stock" :symbol "ohlc"]
   :stock/options                 ["stock" :symbol "options" :expiration :optionSide]
   :stock/peers                   ["stock" :symbol "peers"]
   :stock/previous                ["stock" :symbol "previous"]
   :stock/price                   ["stock" :symbol "price"]
   :stock/price-target            ["stock" :symbol "price-target"]
   :stock/quote                   ["stock" :symbol "quote" :field]
   :stock/recommendation-trends   ["stock" :symbol "recommendation-trends"]
   :stock/sentiment               ["stock" :symbol "sentiment" :type :date]
   :stock/splits                  ["stock" :symbol "splits" :range]
   :stock/stats                   ["stock" :symbol "stats" :stat]
   :stock/upcoming-ipos           ["stock" :symbol "upcoming-ipos"]
   :time-series/PREMIUM_WALLSTREETHORIZON_ANALYST_DAY
   ["time-series" "PREMIUM_WALLSTREETHORIZON_ANALYST_DAY" :symbol :eventId]
   
   :time-series/PREMIUM_WALLSTREETHORIZON_BOARD_OF_DIRECTORS_MEETING
   ["time-series" "PREMIUM_WALLSTREETHORIZON_BOARD_OF_DIRECTORS_MEETING" :symbol
    :eventId]
   
   :time-series/PREMIUM_WALLSTREETHORIZON_BUSINESS_UPDATE
   ["time-series" "PREMIUM_WALLSTREETHORIZON_BUSINESS_UPDATE" :symbol :eventId]
   
   :time-series/PREMIUM_WALLSTREETHORIZON_BUYBACK
   ["time-series" "PREMIUM_WALLSTREETHORIZON_BUYBACK" :symbol :eventId]
   
   :time-series/PREMIUM_WALLSTREETHORIZON_COMPANY_TRAVEL
   ["time-series" "PREMIUM_WALLSTREETHORIZON_COMPANY_TRAVEL" :symbol :eventId]
   
   :time-series/PREMIUM_WALLSTREETHORIZON_MERGER_ACQUISITIONS
   ["time-series" "PREMIUM_WALLSTREETHORIZON_MERGER_ACQUISITIONS" :symbol
    :eventId]
   
   :time-series/PREMIUM_WALLSTREETHORIZON_PRODUCT_EVENTS
   ["time-series" "PREMIUM_WALLSTREETHORIZON_PRODUCT_EVENTS" :symbol :eventId]
   
   :time-series/PREMIUM_WALLSTREETHORIZON_SAME_STORE_SALES
   ["time-series" "PREMIUM_WALLSTREETHORIZON_SAME_STORE_SALES" :symbol :eventId]
   
   :time-series/advanced_bonus        ["time-series" "advanced_bonus" :symbol :refid]
   :time-series/advanced_distribution ["time-series" "advanced_distribution"
                                       :symbol :refid]
   :time-series/advanced_dividends    ["time-series" "advanced_dividends" :symbol
                                       :refid]
   :time-series/advanced_return_of_capital
   ["time-series" "advanced_return_of_capital" :symbol :refid]
   
   :time-series/advanced_right_to_purchase
   ["time-series" "advanced_right_to_purchase" :symbol :refid]
   
   :time-series/advanced_rights ["time-series" "advanced_rights" :symbol :refid]
   :time-series/advanced_security_reclassification
   ["time-series" "advanced_security_reclassification" :symbol :refid]
   
   :time-series/advanced_security_swap ["time-series" "advanced_security_swap"
                                        :symbol :refid]
   :time-series/advanced_spinoff       ["time-series" "advanced_spinoff" :symbol :refid]
   :time-series/advanced_splits        ["time-series" "advanced_splits" :symbol :refid]
   :time-series/economic               ["time-series" "economic" :symbol]
   :time-series/energy                 ["time-series" "energy" :symbol]
   :time-series/market                 ["time-series" "market" :symbol]
   :time-series/reported_financials    ["time-series" "reported_financials" :symbol
                                        :filing]
   :time-series/treasury               ["time-series" "treasury" :symbol]})
