(ns features.pattern-matching.pattern-matching-1b-spec
  (:require [speclj.core :refer [describe it should=]]
            [features.pattern-matching.pattern-matching-1b :refer [match]]))

(describe
 "pattern matching"
 (it "matches an int"
     (let [match-simple-int-input (fn [n]
                                    (match [n]
                                      [0] :zero
                                      [1] :one
                                      [2] :two
                                      :else :other))]
       (should= :zero  (match-simple-int-input 0))
       (should= :one   (match-simple-int-input 1))
       (should= :two   (match-simple-int-input 2))
       (should= :other (match-simple-int-input 3)))))
