(ns features.pattern-matching.pattern-matching-2a-spec
  (:require [speclj.core :refer [describe it should=]]
            [features.pattern-matching.pattern-matching-2a :refer [match]]))

#_{:clj-kondo/ignore [:unresolved-symbol]}
(describe
 "pattern matching"
 (it
  "matches and binds"
  (let [match-and-bind (fn [[a b]]
                         (match [a b]
                           [0 y] {:axis "Y" :y y}
                           [x 0] {:axis "X" :x x}
                           [x y] {:x x :y y}))]
    (should= {:axis "Y" :y 5} (match-and-bind [0 5]))
    (should= {:axis "Y" :y 3} (match-and-bind [0 3]))
    (should= {:axis "X" :x 1} (match-and-bind [1 0]))
    (should= {:axis "X" :x 2} (match-and-bind [2 0]))
    (should= {:x 1 :y 2} (match-and-bind [1 2]))
    (should= {:x 2 :y 1} (match-and-bind [2 1])))))

;; #_{:clj-kondo/ignore [:unresolved-symbol]}
;; (match [a b]
;;   [0 y] {:axis "Y" :y y}
;;   [x 0] {:axis "X" :x x}
;;   [x y] {:x x :y y})

;; macroexpand-1 (form): (match [a b]↵  [0 y] {:axis "Y" :y y}↵  [x 0] {:axis "X" :x x}↵  [x y] {:x x :y y})
;; (cond                                       ; match
;;   (and                                      ; create-test-expression 
;;    (= (count [a b]) 2)
;;    (every?
;;     identity
;;     (map match-item? '[0 y] [a b])))
;;   (let [y b] {:axis "Y", :y y})             ; create-result-with-bindings 

;;   (and                                      ; create-test-expression 
;;    (= (count [a b]) 2)
;;    (every?
;;     identity
;;     (map match-item? '[x 0] [a b])))
;;   (let [x a] {:axis "X", :x x})

;;   (and                                      ; create-test-expression 
;;    (= (count [a b]) 2)
;;    (every?
;;     identity
;;     (map match-item? '[x y] [a b])))
;;   (let [x a, y b] {:x x, :y y}))             ; create-result-with-bindings 
