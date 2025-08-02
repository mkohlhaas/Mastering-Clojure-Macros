(defmacro make-adder [x]
  `(fn [y#] (+ ~x y#)))

y
100
((make-adder (+ y 3)) 5)
108

