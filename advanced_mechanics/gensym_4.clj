(defmacro make-adder [x]
  `(fn [y#] (+ ~x y#)))

user=> y
100
user=> ((make-adder (+ y 3)) 5)
108

