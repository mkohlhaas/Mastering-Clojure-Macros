(defmacro make-adder [x] `(fn [~'y] (+ ~x ~'y)))
;=> #'user/make-adder
(def y 100)
;=> #'user/y
((make-adder (+ y 3)) 5)
;=> 13

