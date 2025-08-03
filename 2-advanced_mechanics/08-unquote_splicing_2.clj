(def other-numbers '(4 5 6 7 8)) ; #'user/other-numbers

;; ✓
;; ~@ = unquote-splicing reader macro
`(1 2 3 ~@other-numbers 9 10) ; (1 2 3 4 5 6 7 8 9 10)
