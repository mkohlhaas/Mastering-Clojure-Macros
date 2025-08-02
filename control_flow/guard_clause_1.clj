(defn follow-user [user user-to-follow]
  (if (contains? @(:blocked user-to-follow) (:name user))
    (println (:name user-to-follow) "has blocked" (:name user))
    (do
      (println "Adding follow relationship...")
      (swap! (:following user) conj (:name user-to-follow))
      (swap! (:followers user-to-follow) conj (:name user)))))
