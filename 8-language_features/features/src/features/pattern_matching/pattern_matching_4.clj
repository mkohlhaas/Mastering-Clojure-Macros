(ns features.pattern-matching.pattern-matching-4
  (:require [features.pattern-matching.pattern-matching-3a :refer [match]]))

#_{:clj-kondo/ignore [:unresolved-symbol]}
;; implementing merge from merge sort with pattern matching
(defn mmerge [xs ys]
  (loop [acc []
         xs xs
         ys ys]
    (match [(seq xs) (seq ys)]
      [nil b] (concat acc b)
      [a nil] (concat acc a)
      [[x & x-rest] [y & y-rest]]
      (if (< x y)
        (recur (conj acc x) x-rest ys)
        (recur (conj acc y) xs y-rest)))))
