#_{:clj-kondo/ignore [:use]}
(use 'criterium.core)

(defn sum [xs] (reduce + xs))

(def collection (range 100))

(bench (sum collection))

(defn array-sum [^ints xs]
  (loop [index 0
         acc   0]
    (if (< index (alength xs))
      (recur (unchecked-inc index)
             (+ acc (aget xs index)))
      acc)))

(def array (into-array Integer/TYPE (range 100)))

(bench (array-sum array))
