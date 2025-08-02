(def a 4)
;=> #'user/a
`(1 2 3 '~a 5)
;=> (1 2 3 (quote 4) 5)
