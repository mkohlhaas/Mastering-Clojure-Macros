(defmacro match [input & more]
  (let [clauses (partition 2 more)]
    `(cond
       ~@(mapcat (fn [[match-expression result]]
                   (if (= :else match-expression)
                     [:else result]
                     [`(= ~input ~match-expression)
                      result]))
                 clauses))))
