(defn match-item? [matchable-item input]
  (cond (symbol? matchable-item) true
        (vector? matchable-item)
        (and (sequential? input)
             (every? identity (map match-item? matchable-item input)))
        :else (= input matchable-item)))

(defn create-bindings-map [input match-expression]
  (let [pairs (map vector match-expression (concat input (repeat nil)))]
    (into {} (filter (fn [[k v]]
                       (not (or (keyword? k)
                                (number? k)
                                (nil? k))))
                     pairs))))
