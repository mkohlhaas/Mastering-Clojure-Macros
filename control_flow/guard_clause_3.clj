(defmacro require-user-not-blocked [user user-to-follow]
  `(shift k#
          (if (contains? @(:blocked ~user-to-follow) (:name ~user))
            (println (:name ~user-to-follow) "has blocked" (:name ~user))
            (k# :ok))))

(defn follow-user [user user-to-follow]
  (reset
   (require-user-not-blocked user user-to-follow)
   (println "Adding follow relationship...")
   (swap! (:following user) conj (:name user-to-follow))
   (swap! (:followers user-to-follow) conj (:name user))))

(swap! (:blocked owen) conj (:name colin))
(follow-user colin owen)
; Owen has blocked Colin
;=> nil
