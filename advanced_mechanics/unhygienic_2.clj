user=> (defmacro squares [xs] `(map (fn [~'x] (* ~'x ~'x)) ~xs))
;=> #'user/squares
user=> (squares (range 10))
;=> (0 1 4 9 16 25 36 49 64 81)

