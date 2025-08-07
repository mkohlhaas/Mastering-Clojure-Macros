;; runtime helper
(defn match-item? [matchable-item input]
  (if (symbol? matchable-item)
    true
    (= input matchable-item)))

;; macroexpansion helpers
(defn create-test-expression [input match-expression]
  `(and (= (count ~input) ~(count match-expression))
        (every? identity
                (map match-item? '~match-expression ~input))))

(defn create-bindings-map [input match-expression]
  (let [pairs (map vector match-expression input)]
    (into {} (filter (comp symbol? first) pairs))))

(defn create-result-with-bindings [input match-expression result]
  (let [bindings-map (create-bindings-map input match-expression)]
    `(let [~@(mapcat identity bindings-map)]
       ~result)))

(defn match-clause [input [match-expression result]]
  (if (= :else match-expression)
    [:else result]
    [(create-test-expression input match-expression)
     (create-result-with-bindings input match-expression result)]))

(defmacro match [input & more]
  (let [clauses (partition 2 more)]
    `(cond ~@(mapcat (partial match-clause input)
                     clauses))))

