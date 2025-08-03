#_{:clj-kondo/ignore [:use]}
(use 'criterium.core)

;; with type hinting to avoid reflection
(defn length-2 [^String x] (.length x))

(bench (length-2 "hi there!"))
; (out) Evaluation count : 1572720060 in 60 samples of 26212001 calls.
; (out)              Execution time mean : 13.102888 ns
; (out)     Execution time std-deviation : 0.709000 ns
; (out)    Execution time lower quantile : 12.643250 ns ( 2.5%)
; (out)    Execution time upper quantile : 15.111143 ns (97.5%)
; (out)                    Overhead used : 25.468087 ns
; (out) 
; (out) Found 9 outliers in 60 samples (15.0000 %)
; (out) 	low-severe	 1 (1.6667 %)
; (out) 	low-mild	 8 (13.3333 %)
; (out)  Variance from outliers : 40.1225 % Variance is moderately inflated by outliers

;; without type hinting, but calling directly, also avoids reflection
;; Oops, much faster!
(bench (.length "hi there!"))
; (out) Evaluation count : 2307623280 in 60 samples of 38460388 calls.
; (out)              Execution time mean : 0.005175 ns
; (out)     Execution time std-deviation : 0.098065 ns
; (out)    Execution time lower quantile : -0.072463 ns ( 2.5%)
; (out)    Execution time upper quantile : 0.220532 ns (97.5%)
; (out)                    Overhead used : 25.468087 ns
; (out) 
; (out) Found 9 outliers in 60 samples (15.0000 %)
; (out) 	low-severe	 3 (5.0000 %)
; (out) 	low-mild	 6 (10.0000 %)
; (out)  Variance from outliers : 98.3333 % Variance is severely inflated by outliers
;             Execution time mean : 3.423909 ns
;    Execution time std-deviation : 0.202517 ns
