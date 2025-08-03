(defmacro square [x] `(* ~x ~x))

;; getting a function out of the macro
@#'square
; #object[clojure.lang.AFunction$1 0xebdd450 "clojure.lang.AFunction$1@ebdd450"]

;; indeed it is a function
(fn? @#'square) ; true
