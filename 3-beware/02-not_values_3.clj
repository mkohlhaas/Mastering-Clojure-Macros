(defmacro do-multiplication [expression]
  (cons `* (rest expression)))

(do-multiplication (+ 3 4)) ; 12

;; function wrapping trick does not work in this case
(map (fn [x] (do-multiplication x)) ['(+ 3 4) '(- 2 3)])
; (err) java.lang.IllegalArgumentException: Don't know how to create ISeq from: clojure.lang.Symbol
; `do-multiplication` takes an `x` and needs to take the `rest` of it. Doesn't know how bc `x` is a symbol.
