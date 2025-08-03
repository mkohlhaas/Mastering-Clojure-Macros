(defmacro make-adder [x] `(fn [~'y] (+ ~x ~'y)))

(def y 100) ; #'syntax-quote-7/y

((make-adder (+ y 3)) 5) ; 13
;; ((fn* ([y] (clojure.core/+ (+ y 3) y))) 5)
