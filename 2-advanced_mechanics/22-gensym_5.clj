(defmacro safe-math-expression? [expression]
  `(try ~expression
        true
        (catch ArithmeticException e# false)))

;; clojure.core/and
;; Syntax-reader uses gensym for non-namespace-qualified symbols ending with '#'.
;; Syntax-reader gensyms are only generated once, at read time so recursive
;; macros get the same generated symbol for all levels of recursion.
(defmacro and
  ([] true)
  ([x] x)
  ([x & next]
   `(let [and# ~x]
      (if and# (and ~@next) and#)))) ; #'syntax-quote-7/and
