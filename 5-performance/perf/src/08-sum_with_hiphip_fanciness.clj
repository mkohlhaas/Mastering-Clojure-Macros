#_{:clj-kondo/ignore [:use]}
(use 'criterium.core)

(require '[hiphip.int])

(def array (into-array Integer/TYPE (range 100)))

(defn array-sum-of-squares [^ints xs]
  (areduce xs index ret 0 (+ ret (let [x (aget xs index)] (* x x)))))

(bench (array-sum-of-squares array))

#_{:clj-kondo/ignore [:unresolved-symbol]}
(bench (hiphip.int/asum [n array] (* n n)))
; (out) Evaluation count : 57607020 in 60 samples of 960117 calls.
; (out)              Execution time mean : 1.028769 µs
; (out)     Execution time std-deviation : 26.196755 ns
; (out)    Execution time lower quantile : 1.005662 µs ( 2.5%)
; (out)    Execution time upper quantile : 1.095510 µs (97.5%)
; (out)                    Overhead used : 33.889555 ns
; (out) 
; (out) Found 5 outliers in 60 samples (8.3333 %)
; (out) 	low-severe	 5 (8.3333 %)
; (out)  Variance from outliers : 12.6194 % Variance is moderately inflated by outliers
