(defproject foo "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :jvm-opts ^:replace []
  :profiles {:dev {:dependencies [[criterium "0.4.2"]]}})

