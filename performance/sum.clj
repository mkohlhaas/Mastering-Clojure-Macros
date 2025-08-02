(defn sum [xs]
  (reduce + xs))
(def collection (range 100))
(bench (sum collection))
;             Execution time mean : 2.078925 µs
;    Execution time std-deviation : 378.988150 ns

(defn array-sum [^ints xs]
  (loop [index 0
         acc 0]
    (if (< index (alength xs))
      (recur (unchecked-inc index) (+ acc (aget xs index)))
      acc)))
(def array (into-array Integer/TYPE (range 100)))
(bench (array-sum array))
;             Execution time mean : 161.939607 ns
;    Execution time std-deviation : 5.566530 ns

