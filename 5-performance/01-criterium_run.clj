(use 'criterium.core)
(defn length-1 [x] (.length x))
;=> #'user/length-1
(bench (length-1 "hi there!"))
;Evaluation count : 26255400 in 60 samples of 437590 calls.
;             Execution time mean : 3.250388 µs
;    Execution time std-deviation : 850.690042 ns
;   Execution time lower quantile : 2.303419 µs ( 2.5%)
;   Execution time upper quantile : 5.038536 µs (97.5%)
;                   Overhead used : 2.193109 ns
;
;Found 1 outliers in 60 samples (1.6667 %)
;        low-severe       1 (1.6667 %)
; Variance from outliers : 94.6569 % Variance is severely inflated by outliers
;=> nil

