(defn array-sum [^ints xs]
  (areduce xs index ret 0 (+ ret (aget xs index))))

(bench (array-sum array))
;             Execution time mean : 170.214852 ns
;    Execution time std-deviation : 18.504698 ns
