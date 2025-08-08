(ns features.pattern-matching.pattern-matching-2a)

;; runtime helper
(defn match-item? [matchable-item input]
  (if (symbol? matchable-item)
    true
    (= input matchable-item)))

;; matchable-item => 0  input => 0  
;; matchable-item => y  input => 5  
;; matchable-item => 0  input => 0  
;; matchable-item => y  input => 3  
;; matchable-item => 0  input => 1  
;; matchable-item => x  input => 1  
;; matchable-item => 0  input => 0  
;; matchable-item => 0  input => 2  
;; matchable-item => x  input => 2  
;; matchable-item => 0  input => 0  
;; matchable-item => 0  input => 1  
;; matchable-item => x  input => 1  
;; matchable-item => 0  input => 2  
;; matchable-item => x  input => 1  
;; matchable-item => y  input => 2  
;; matchable-item => 0  input => 2  
;; matchable-item => x  input => 2  
;; matchable-item => 0  input => 1  
;; matchable-item => x  input => 2  
;; matchable-item => y  input => 1) 

;; macroexpansion helpers
(defn create-test-expression [input match-expression]
  `(and (= (count ~input) ~(count match-expression))
        (every? identity
                (map match-item? '~match-expression ~input))))

;; (map + [1 2 3] [3 2 1]) ; (4 4 4)

;; input => [a b]
;; match-expression => [0 y]
;; match-expression => [x 0]
;; match-expression => [x y]

(defn create-bindings-map [input match-expression]
  (let [pairs (map vector match-expression input)]
    (into {} (filter (comp symbol? first) pairs))))

;; input => [a b] match-expression => [0 y] pairs => ([0 a] [y b]) -> {y b}
;; input => [a b] match-expression => [x 0] pairs => ([x a] [0 b]) -> {x a}
;; input => [a b] match-expression => [x y] pairs => ([x a] [y b]) -> {x a, y b}

(defn create-result-with-bindings [input match-expression result]
  (let [bindings-map (create-bindings-map input match-expression)]
    `(let [~@(mapcat identity bindings-map)]
       ~result)))

;; input => [a b]
;; match-expression => [0 y]  result => {:axis "Y", :y y}  bindings-map => {y b}
;; match-expression => [x 0]  result => {:axis "X", :x x}  bindings-map => {x a}
;; match-expression => [x y]) result => {:x x, :y y})      bindings-map => {x a, y b}

(defn match-clause [input [match-expression result]]
  (if (= :else match-expression)
    [:else result]
    [(create-test-expression input match-expression)
     (create-result-with-bindings input match-expression result)]))

(defmacro match [input & more]
  (let [clauses (partition 2 more)]
    `(cond ~@(mapcat
              (partial match-clause input)
              clauses))))
