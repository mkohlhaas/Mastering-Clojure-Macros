(defmacro squares [xs] `(map #(* % %) ~xs))

(squares (range 10)) ; (0 1 4 9 16 25 36 49 64 81)

(ns syntax-quote-7 (:refer-clojure :exclude [map]))

(def map {:a 1 :b 2}) ; #'syntax-quote-7/map

#_{:clj-kondo/ignore [:unresolved-namespace]}
(user/squares (range 10)) ; (0 1 2 3 4 5 6 7 8 9)

(first (macroexpand '(user/squares (range 10)))) ; map
