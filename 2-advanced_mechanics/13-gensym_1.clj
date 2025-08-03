(defmacro squares [xs] `(map (fn [x] (* x x)) ~xs))

(squares (range 10)) ; (0 1 2 3 4 5 6 7 8 9)
; not any more in current Clojure version:
;=> CompilerException java.lang.RuntimeException:
;  Can't use qualified name as parameter: user/x, compiling: (NO_SOURCE_PATH:1:1)
