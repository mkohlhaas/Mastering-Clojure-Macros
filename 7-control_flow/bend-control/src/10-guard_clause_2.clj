;; use `lein repl` not babashka!

#_{:clj-kondo/ignore [:refer-all]}
(ns guard-clause-2
  (:require [delimc.core :refer :all]))

;; (require '[delimc.core :refer [reset shift]])

(defn make-user [name]
  {:name name
   :blocked (atom #{})
   :following (atom #{})
   :followers (atom #{})})

(def colin (make-user "Colin"))
(def owen  (make-user "Owen"))

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defn follow-user [user user-to-follow]
  (reset
   (shift k
          (if (contains? @(:blocked user-to-follow) (:name user))
            (println (:name user-to-follow) "has blocked" (:name user))
            (k :ok))) ; early return
   (println "Adding follow relationship...")
   (swap! (:following user) conj (:name user-to-follow))
   (swap! (:followers user-to-follow) conj (:name user))))

; adds colin to owen's blocked list (i.e. owen blocks colin)
(swap! (:blocked owen) conj (:name colin)) ; #{"Colin"}

(follow-user colin owen)
; (out) Owen has blocked Colin
