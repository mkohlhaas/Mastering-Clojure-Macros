user=> (defmacro make-adder [x] `(fn [~'y] (+ ~x ~'y)))
;=> #'user/make-adder
user=> (macroexpand-1 '(make-adder 10))
;=> (clojure.core/fn [y] (clojure.core/+ 10 y))
