user=> (defmacro square [x] `(* ~x ~x))
;=> #'user/square
user=> (map (fn [n] (square n)) (range 10))
;=> (0 1 4 9 16 25 36 49 64 81)

