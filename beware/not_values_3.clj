(defmacro do-multiplication [expression]
  (cons `* (rest expression)))

user=> (do-multiplication (+ 3 4))
;=> 12
user=> (map (fn [x] (do-multiplication x)) ['(+ 3 4) '(- 2 3)])
; CompilerException java.lang.IllegalArgumentException:
;   Don't know how to create ISeq from: clojure.lang.Symbol,
;   compiling:(NO_SOURCE_PATH:1:14)
