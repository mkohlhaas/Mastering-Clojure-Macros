(let [expression (read-string "(+ 1 2 3 4 5)")]
  (cons (read-string "*")
        (rest expression)))
; (* 1 2 3 4 5)

*1 ;; *1 holds the result of the previous REPL evaluation
; (* 1 2 3 4 5)

(eval *1)
; 120
