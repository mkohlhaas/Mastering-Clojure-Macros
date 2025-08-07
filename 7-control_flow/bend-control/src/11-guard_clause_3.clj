#_{:clj-kondo/ignore [:refer-all]}
(require '[delimc.core :refer :all])

(defn make-user [name]
  {:name name
   :blocked (atom #{})
   :following (atom #{})
   :followers (atom #{})})

(def colin (make-user "Colin"))
(def owen  (make-user "Owen"))

(defmacro require-user-not-blocked [user user-to-follow]
  `(shift k#
          (if (contains? @(:blocked ~user-to-follow) (:name ~user))
            (println (:name ~user-to-follow) "has blocked" (:name ~user))
            (k# :ok))))

(defn follow-user [user user-to-follow]
  (reset
   (require-user-not-blocked user user-to-follow) ; early return if blocked
   (println "Adding follow relationship...")
   (swap! (:following user) conj (:name user-to-follow))
   (swap! (:followers user-to-follow) conj (:name user))))

(swap! (:blocked owen) conj (:name colin))
; #{"Colin"}

(follow-user colin owen)
; (out) Owen has blocked Colin
