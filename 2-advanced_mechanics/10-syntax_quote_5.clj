(defmacro squares [xs] (list 'map '#(* % %) xs)) ; #'user/squares

(squares (range 10)) ; (0 1 4 9 16 25 36 49 64 81)
;; (map (fn* [%1] (* %1 %1)) (range 10))
