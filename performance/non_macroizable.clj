(defn calculate-estimate [project-id]
  (let [{:keys [optimistic realistic pessimistic]}
        (fetch-estimates-from-web-service project-id)
        weighted-mean (/ (+ optimistic (* realistic 4) pessimistic) 6)
        std-dev (/ (- pessimistic optimistic) 6)]
    (double (+ weighted-mean (* 2 std-dev)))))
