#_{:clj-kondo/ignore [:use]}
;; https://github.com/swannodette/delimc
(use 'delimc.core) ;; gives us `shift` and `reset`

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
            (k :ok)))
   (println "Adding follow relationship...")
   (swap! (:following user) conj (:name user-to-follow))
   (swap! (:followers user-to-follow) conj (:name user))))

(swap! (:blocked owen) conj (:name colin))
(follow-user colin owen)
; Owen has blocked Colin
