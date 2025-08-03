(defmacro square [x] `(* ~x ~x))

;; wrapping macro in a function can do the trick
(map (fn [n] (square n)) (range 10))
; (0 1 4 9 16 25 36 49 64 81)

