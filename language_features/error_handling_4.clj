(defmacro match [input & more]
  {:pre [(vector? input)
         (even? (count more))]}
  (let [clauses (partition 2 more)]
    `(cond ~@(mapcat (partial match-clause input)
                     clauses))))

