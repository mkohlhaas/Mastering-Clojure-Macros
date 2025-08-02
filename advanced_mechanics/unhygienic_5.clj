user=> (macroexpand-1 '(make-adder (+ y 3)))
;=> (clojure.core/fn [y] (clojure.core/+ (+ y 3) y))
