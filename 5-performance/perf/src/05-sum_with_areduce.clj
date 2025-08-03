#_{:clj-kondo/ignore [:use]}
(use 'criterium.core)

(def array (into-array Integer/TYPE (range 100)))

(defn array-sum [^ints xs]
  (areduce xs index ret 0 (+ ret (aget xs index))))

(bench (array-sum array))
;             Execution time mean : 170.214852 ns
;    Execution time std-deviation : 18.504698 ns
