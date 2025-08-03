(defmacro squares [xs] `(map (fn [~'x] (* ~'x ~'x)) ~xs))

(squares (range 10)) ; (0 1 2 3 4 5 6 7 8 9)
