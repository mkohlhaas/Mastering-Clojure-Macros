(defn match-clause [input [match-expression result]]
  (if (= :else match-expression)
    [:else result]
    [`(= ~input ~match-expression)
     result]))

(defmacro match [input & more]
  (let [clauses (partition 2 more)]
    `(cond ~@(mapcat (partial match-clause input)
                     clauses))))

