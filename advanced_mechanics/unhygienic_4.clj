user=> (defmacro make-adder [x] `(fn [~'y] (+ ~x ~'y)))
;=> #'user/make-adder
user=> (def y 100)
;=> #'user/y
user=> ((make-adder (+ y 3)) 5)
;=> 13

