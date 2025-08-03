(ns syntax-quote-6 (:refer-clojure :exclude [map]))

;; but now `map` is redefined
(def map {:a 1 :b 2}) ; #'syntax-quote-6/map

#_{:clj-kondo/ignore [:unresolved-namespace]}
(user/squares (range 10)) ; (0 1 2 3 4 5 6 7 8 9)

#_{:clj-kondo/ignore [:unresolved-namespace]}
(user/squares :a) ; :a

(first (macroexpand '(user/squares (range 10)))) ; map

({:a 1 :b 2} :nonexistent-key :default-value) ; :default-value
