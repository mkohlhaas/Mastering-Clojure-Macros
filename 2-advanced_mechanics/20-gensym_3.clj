(defmacro make-adder [x]
  (let [y (gensym)]
    `(fn [~y] (+ ~x ~y))))

y ; 100

((make-adder (+ y 3)) 5) ; 108
