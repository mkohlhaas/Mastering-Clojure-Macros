(let [expression '(+ 1 2 3 4 5)]
  (cons '* (rest expression)))
; (* 1 2 3 4 5)
