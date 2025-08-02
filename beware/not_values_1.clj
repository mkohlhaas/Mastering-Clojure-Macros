(defn square [x] (* x x))
;=> #'user/square
(map square (range 10))
;=> (0 1 4 9 16 25 36 49 64 81)
(defmacro square [x] `(* ~x ~x))
;=> #'user/square
(map square (range 10))
;CompilerException java.lang.RuntimeException:
;  Can't take value of a macro: #'user/square, compiling: (NO_SOURCE_PATH:1:1)
