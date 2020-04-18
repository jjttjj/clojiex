(ns dev.jt.clojiex.data.path-params)

(def op->kw-segs
  {:account/usage                         ["account" "usage" :type]
   :crypto/book                           ["crypto" :symbol "book"]
   :crypto/price                          ["crypto" :symbol "price"]
   :crypto/quote                          ["crypto" :symbol "quote"]
   :data-points/market                    ["data-points" "market" :symbol]
   :ref-data.exchange/symbols             ["ref-data" "exchange" :exchange "symbols"]
   :ref-data.region/symbols               ["ref-data" "region" :region "symbols"]
   :ref-data.us/dates                     ["ref-data" "us" "dates" :type :direction :last :startDate]
   :search                                ["search" :fragment]
   :stable.rules/info                     ["stable" "rules" "info" :id]
   :stable.rules/lookup                   ["stable" "rules" "lookup" :value]
   :stable.rules/output                   ["stable" "rules" "output" :id]
   :stock.market/collection               ["stock" "market" "collection" :collectionType]
   :stock.market/list                     ["stock" "market" "list" :list-type]
   :stock.news/last                       ["stock" :symbol "news" "last" :last]
   :stock/advanced-stats                  ["stock" :symbol "advanced-stats"]
   :stock/balance-sheet                   ["stock" :symbol "balance-sheet"]
   :stock/batch                           ["stock" :symbol "batch"]
   :stock/book                            ["stock" :symbol "book"]
   :stock/cash-flow                       ["stock" :symbol "cash-flow"]
   :stock/ceo-compensation                ["stock" :symbol "ceo-compensation"]
   :stock/chart                           ["stock" :symbol "chart" :range :date]
   :stock/company                         ["stock" :symbol "company"]
   :stock/delayed-quote                   ["stock" :symbol "delayed-quote"]
   :stock/dividends                       ["stock" :symbol "dividends" :range]
   :stock/earnings                        ["stock" :symbol "earnings" :last]
   :stock/estimates                       ["stock" :symbol "estimates"]
   :stock/financials                      ["stock" :symbol "financials"]
   :stock/fund-ownership                  ["stock" :symbol "fund-ownership"]
   :stock/income                          ["stock" :symbol "income"]
   :stock/indicator                       ["stock" :symbol "indicator" :indicator-name]
   :stock/insider-roster                  ["stock" :symbol "insider-roster"]
   :stock/insider-summary                 ["stock" :symbol "insider-summary"]
   :stock/insider-transactions            ["stock" :symbol "insider-transactions"]
   :stock/institutional-ownership         ["stock" :symbol "institutional-ownership"]
   :stock/intraday-prices                 ["stock" :symbol "intraday-prices"]
   :stock/largest-trades                  ["stock" :symbol "largest-trades"]
   :stock/logo                            ["stock" :symbol "logo"]
   :stock/news                            ["stock" :symbol "news"]
   :stock/ohlc                            ["stock" :symbol "ohlc"]
   :stock/options                         ["stock" :symbol "options" :expiration :optionSide]
   :stock/peers                           ["stock" :symbol "peers"]
   :stock/previous                        ["stock" :symbol "previous"]
   :stock/price                           ["stock" :symbol "price"]
   :stock/price-target                    ["stock" :symbol "price-target"]
   :stock/quote                           ["stock" :symbol "quote" :field]
   :stock/recommendation-trends           ["stock" :symbol "recommendation-trends"]
   :stock/sentiment                       ["stock" :symbol "sentiment" :type :date]
   :stock/splits                          ["stock" :symbol "splits" :range]
   :stock/stats                           ["stock" :symbol "stats" :stat]
   :stock/threshold-securities            ["stock" :symbol "threshold-securities"]
   :stock/upcoming-dividends              ["stock" :symbol "upcoming-dividends"]
   :stock/upcoming-earnings               ["stock" :symbol "upcoming-earnings"]
   :stock/upcoming-events                 ["stock" :symbol "upcoming-events"]
   :stock/upcoming-ipos                   ["stock" :symbol "upcoming-ipos"]
   :stock/upcoming-splits                 ["stock" :symbol "upcoming-splits"]
   :stock/volume-by-venue                 ["stock" :symbol "volume-by-venue"]
   :time-series                           ["time-series" :id :key :subkey]
   :time-series/PREMIUM_AUDIT_ANALYTICS_ACCOUNTING_QUALITY_RISK_MATRIX
   ["time-series" "PREMIUM_AUDIT_ANALYTICS_ACCOUNTING_QUALITY_RISK_MATRIX"
    :symbol]
   :time-series/PREMIUM_AUDIT_ANALYTICS_DIRECTOR_OFFICER_CHANGES
   ["time-series" "PREMIUM_AUDIT_ANALYTICS_DIRECTOR_OFFICER_CHANGES" :symbol]
   :time-series/PREMIUM_BRAIN_LANGUAGE_DIFFERENCES_10K
   ["time-series" "PREMIUM_BRAIN_LANGUAGE_DIFFERENCES_10K" :symbol]
   :time-series/PREMIUM_BRAIN_LANGUAGE_DIFFERENCES_ALL
   ["time-series" "PREMIUM_BRAIN_LANGUAGE_DIFFERENCES_ALL" :symbol]
   :time-series/PREMIUM_BRAIN_LANGUAGE_METRICS_10K
   ["time-series" "PREMIUM_BRAIN_LANGUAGE_METRICS_10K" :symbol]
   :time-series/PREMIUM_BRAIN_LANGUAGE_METRICS_ALL
   ["time-series" "PREMIUM_BRAIN_LANGUAGE_METRICS_ALL" :symbol]
   :time-series/PREMIUM_BRAIN_RANKING_10_DAYS
   ["time-series" "PREMIUM_BRAIN_RANKING_10_DAYS" :symbol]
   :time-series/PREMIUM_BRAIN_RANKING_21_DAYS
   ["time-series" "PREMIUM_BRAIN_RANKING_21_DAYS" :symbol]
   :time-series/PREMIUM_BRAIN_RANKING_2_DAYS
   ["time-series" "PREMIUM_BRAIN_RANKING_2_DAYS" :symbol]
   :time-series/PREMIUM_BRAIN_RANKING_3_DAYS
   ["time-series" "PREMIUM_BRAIN_RANKING_3_DAYS" :symbol]
   :time-series/PREMIUM_BRAIN_RANKING_5_DAYS
   ["time-series" "PREMIUM_BRAIN_RANKING_5_DAYS" :symbol]
   :time-series/PREMIUM_BRAIN_SENTIMENT_30_DAYS
   ["time-series" "PREMIUM_BRAIN_SENTIMENT_30_DAYS" :symbol]
   :time-series/PREMIUM_BRAIN_SENTIMENT_7_DAYS
   ["time-series" "PREMIUM_BRAIN_SENTIMENT_7_DAYS" :symbol]
   :time-series/PREMIUM_EXTRACT_ALPHA_CAM ["time-series"
                                           "PREMIUM_EXTRACT_ALPHA_CAM" :symbol]
   :time-series/PREMIUM_EXTRACT_ALPHA_ESG
   ["time-series" "PREMIUM_EXTRACT_ALPHA_ESG" :symbol :eventType]
   :time-series/PREMIUM_EXTRACT_ALPHA_TM  ["time-series" "PREMIUM_EXTRACT_ALPHA_TM"
                                           :symbol]
   :time-series/PREMIUM_FRAUD_FACTORS_NON_TIMELY_FILINGS
   ["time-series" "PREMIUM_FRAUD_FACTORS_NON_TIMELY_FILINGS" :symbol]
   :time-series/PREMIUM_FRAUD_FACTORS_SIMILARITY_INDEX
   ["time-series" "PREMIUM_FRAUD_FACTORS_SIMILARITY_INDEX" :symbol]
   :time-series/PREMIUM_KAVOUT_KSCORE     ["time-series" "PREMIUM_KAVOUT_KSCORE"
                                           :symbol]
   :time-series/PREMIUM_KAVOUT_KSCORE_A_SHARES
   ["time-series" "PREMIUM_KAVOUT_KSCORE_A_SHARES" :symbol]
   :time-series/PREMIUM_PRECISION_ALPHA_PRICE_DYNAMICS
   ["time-series" "PREMIUM_PRECISION_ALPHA_PRICE_DYNAMICS" :symbol]
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
   :time-series/advanced_bonus            ["time-series" "advanced_bonus" :symbol :refid]
   :time-series/advanced_distribution     ["time-series" "advanced_distribution"
                                           :symbol :refid]
   :time-series/advanced_dividends        ["time-series" "advanced_dividends" :symbol
                                           :refid]
   :time-series/advanced_return_of_capital
   ["time-series" "advanced_return_of_capital" :symbol :refid]
   :time-series/advanced_right_to_purchase
   ["time-series" "advanced_right_to_purchase" :symbol :refid]
   :time-series/advanced_rights           ["time-series" "advanced_rights" :symbol :refid]
   :time-series/advanced_security_reclassification
   ["time-series" "advanced_security_reclassification" :symbol :refid]
   :time-series/advanced_security_swap    ["time-series" "advanced_security_swap"
                                           :symbol :refid]
   :time-series/advanced_spinoff          ["time-series" "advanced_spinoff" :symbol :refid]
   :time-series/advanced_splits           ["time-series" "advanced_splits" :symbol :refid]
   :time-series/economic                  ["time-series" "economic" :symbol]
   :time-series/energy                    ["time-series" "energy" :symbol]
   :time-series/market                    ["time-series" "market" :symbol]
   :time-series/news                      ["time-series" "news" :symbol]
   :time-series/reported_financials       ["time-series" "reported_financials" :symbol
                                           :filing]
   :time-series/treasury                  ["time-series" "treasury" :symbol]})
