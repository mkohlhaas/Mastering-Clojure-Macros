(def a 4) ; #'user/a

;; what is the result of '~ ?
;; expand a then quote it
;; ~ is the unquote reader macro
`(1 2 3 '~a 5) ; (1 2 3 '4 5)
