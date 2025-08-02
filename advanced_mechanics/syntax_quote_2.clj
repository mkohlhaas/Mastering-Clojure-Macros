user=> (def a 4)
;=> #'user/a
user=> `(1 2 3 '~a 5)
;=> (1 2 3 (quote 4) 5)
