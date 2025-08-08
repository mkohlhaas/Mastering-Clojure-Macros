(ns features.pattern-matching.pattern-matching-3a)

;; NOTE: changed from previous version
(defn match-item? [matchable-item input]
  (cond (symbol? matchable-item) true
        (vector? matchable-item) (and (sequential? input) (every? identity (map match-item? matchable-item input)))
        :else (= input matchable-item)))

(defn create-test-expression [input match-expression]
  `(and (= (count ~input) ~(count match-expression))
        (every? identity
                (map match-item? '~match-expression ~input))))

;; NOTE: changed from previous version
(defn create-bindings-map [input match-expression]
  (let [pairs (map vector match-expression (concat input (repeat nil)))]
    (into {} (filter (fn [[k _v]]
                       (not (or (keyword? k)
                                (number? k)
                                (nil? k))))
                     pairs))))

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
