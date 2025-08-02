user=> (defmacro squares [xs] `(map (fn [x] (* x x)) ~xs))
;=> #'user/squares
user=> (squares (range 10))
;=> CompilerException java.lang.RuntimeException:
;  Can't use qualified name as parameter: user/x, compiling: (NO_SOURCE_PATH:1:1)

