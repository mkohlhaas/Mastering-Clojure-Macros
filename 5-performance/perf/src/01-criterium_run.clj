#_{:clj-kondo/ignore [:use]}
(use 'criterium.core)

;; simple benchmarking tests
(bench (Thread/sleep 1000))
(bench (Thread/sleep 1000) :verbose)
(with-progress-reporting (bench (Thread/sleep 1000)))
(with-progress-reporting (bench (Thread/sleep 1000) :verbose))

;; from the book
(defn length-1 [x] (.length x))

(with-progress-reporting (bench (length-1 "hi there!")))

; (out) Warming up for JIT optimisations 10000000000 ...
; (out)   compilation occurred before 1 iterations
; (out)   classes loaded before 13756 iterations
; (out)   compilation occurred before 13756 iterations
; (out)   compilation occurred before 27511 iterations
; (out)   compilation occurred before 343876 iterations
; (out)   compilation occurred before 357631 iterations
; (out)   compilation occurred before 412651 iterations
; (out) Estimating execution count ...
; (out) Sampling ...
; (out) Final GC...
; (out) Checking GC...
; (out) Finding outliers ...
; (out) Bootstrapping ...
; (out) Checking outlier significance
; (out) Evaluation count : 6899640 in 60 samples of 114994 calls.
; (out)              Execution time mean : 8.759068 µs
; (out)     Execution time std-deviation : 835.029404 ns
; (out)    Execution time lower quantile : 8.391865 µs ( 2.5%)
; (out)    Execution time upper quantile : 11.333160 µs (97.5%)
; (out)                    Overhead used : 25.468087 ns
; (out) 
; (out) Found 9 outliers in 60 samples (15.0000 %)
; (out) 	low-severe	 9 (15.0000 %)
; (out)  Variance from outliers : 66.9954 % Variance is severely inflated by outliers
