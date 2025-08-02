(let [expression (+ 1 2 3 4 5)] ;; expression is bound to 15
  (cons
   (read-string "*")            ;; *
   (rest expression)))          ;; (rest 15)
; (err) java.lang.IllegalArgumentException
