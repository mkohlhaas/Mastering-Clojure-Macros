(let [expression (quote (+ 1 2 3 4 5))]
  (cons (quote *)
        (rest expression)))
; (* 1 2 3 4 5)

(let [expression '(+ 1 2 3 4 5)]
  (cons '*
        (rest expression)))
; (* 1 2 3 4 5)
