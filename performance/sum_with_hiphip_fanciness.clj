(defn array-sum-of-squares [^ints xs]
  (areduce xs index ret 0 (+ ret (let [x (aget xs index)] (* x x)))))

(bench (array-sum-of-squares array))
;             Execution time mean : 1.419661 µs
;    Execution time std-deviation : 256.799353 ns

(bench (hiphip.int/asum [n array] (* n n)))
;            Execution time mean : 1.591465 µs
;    Execution time std-deviation : 232.503393 ns

