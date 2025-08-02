;; Assertions, using custom error messages
(defmacro match [input & more]
  (assert (vector? input) "Match input must be a vector")
  (let [clauses (partition 2 more)]
    `(cond ~@(mapcat (partial match-clause input)
                     clauses))))

;; Clojure preconditions
(defmacro match [input & more]
  {:pre [(vector? input)]}
  (let [clauses (partition 2 more)]
    `(cond ~@(mapcat (partial match-clause input)
                     clauses))))
