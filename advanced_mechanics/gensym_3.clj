(defmacro make-adder [x]
  (let [y (gensym)]
    `(fn [~y] (+ ~x ~y))))

user=> y
100
user=> ((make-adder (+ y 3)) 5)
108
