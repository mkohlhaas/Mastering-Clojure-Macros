(let [expression (read-string "(+ 1 2 3 4 5)")]
  (cons (read-string "*")
        (rest expression)))
;=> (* 1 2 3 4 5)
(eval *1) ;; *1 holds the result of the previous REPL evaluation
;=> 120
