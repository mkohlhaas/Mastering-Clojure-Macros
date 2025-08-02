(ns hello-world.handler
  (:require [clout.core :refer [route-compile]]
            [compojure.core :refer [routes make-route]]
            [compojure.route :refer [not-found]]))

(def app
  (routes
   (make-route :get (route-compile "/")
               (fn [request] "Hello World"))
   (not-found "Page not found")))

