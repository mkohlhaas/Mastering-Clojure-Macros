(ns features.pattern-matching.pattern-matching-3a-spec
  (:require [speclj.core :refer [describe it should=]]
            [features.pattern-matching.pattern-matching-3a :refer [match]]))

#_{:clj-kondo/ignore [:unresolved-symbol]}
(describe
 "pattern matching"
 (it "handles vector destructuring"
     (let [match-and-bind (fn [[a b]]
                            (match [a b]
                              [0 [y & more]] {:axis "Y" :y y :more more}
                              [[x & more] 0] {:axis "X" :x x :more more}
                              [x y] {:x x :y y}))]
       (should= {:axis "Y" :y 5 :more [6 7]} (match-and-bind [0 [5 6 7]]))
       (should= {:axis "X" :x 1 :more [2 3]} (match-and-bind [[1 2 3] 0]))
       (should= {:x 1 :y 2} (match-and-bind [1 2])))))
