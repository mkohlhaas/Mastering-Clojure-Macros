(defproject trptcolin/trymplicit "0.0.1-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 ;; includes https://github.com/ztellman/riddley/pull/13
                 [org.clojars.trptcolin/riddley "0.1.7.1"]]
  :profiles {:dev {:dependencies [[speclj "3.0.2"]]}}
  :plugins [[speclj "3.0.2"]]
  :test-paths ["spec"])
