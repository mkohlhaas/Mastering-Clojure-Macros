(ns hello-world
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defroutes app
  (GET "/" [] "Hello World")
  (not-found "Page not found"))
