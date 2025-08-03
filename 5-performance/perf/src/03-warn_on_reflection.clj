#_{:clj-kondo/ignore [:use]}
(use 'criterium.core)

(set! *warn-on-reflection* true)

;; reflection
(defn length-1 [x] (.length x))
; (err) Reflection warning

;; no reflection
(defn length-2 [^String x] (.length x))

(bench (length-1 "hi there!"))
; (out) Evaluation count : 6934320 in 60 samples of 115572 calls.
; (out)              Execution time mean : 8.253127 µs
; (out)     Execution time std-deviation : 151.413835 ns
; (out)    Execution time lower quantile : 8.183950 µs ( 2.5%)
; (out)    Execution time upper quantile : 8.366199 µs (97.5%)
; (out)                    Overhead used : 25.468087 ns
; (out) 
; (out) Found 3 outliers in 60 samples (5.0000 %)
; (out) 	low-severe	 2 (3.3333 %)
; (out) 	low-mild	 1 (1.6667 %)
; (out)  Variance from outliers : 7.7960 % Variance is slightly inflated by outliers

;; Slower!!!
(bench (length-2 "hi there!"))
; (out) Evaluation count : 1573228260 in 60 samples of 26220471 calls.
; (out)              Execution time mean : 12.713706 ns
; (out)     Execution time std-deviation : 0.173146 ns
; (out)    Execution time lower quantile : 12.632121 ns ( 2.5%)
; (out)    Execution time upper quantile : 12.820545 ns (97.5%)
; (out)                    Overhead used : 25.468087 ns
; (out) 
; (out) Found 3 outliers in 60 samples (5.0000 %)
; (out) 	low-severe	 2 (3.3333 %)
; (out) 	low-mild	 1 (1.6667 %)
; (out)  Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
