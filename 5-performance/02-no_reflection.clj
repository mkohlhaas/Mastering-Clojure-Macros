(defn length-2 [^String x] (.length x))
;=> #'user/length-2
(bench (length-2 "hi there!"))
;             Execution time mean : 1.476211 ns
;    Execution time std-deviation : 0.295418 ns

(bench (.length "hi there!"))
;             Execution time mean : 3.423909 ns
;    Execution time std-deviation : 0.202517 ns
