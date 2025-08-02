(ns delimc.core)

snip
(defmulti transform (fn [[op & forms] k-expr] (keyword op)))
snip

(defn shift* [cc]
  (throw (Exception.
          "Please ensure shift is called from within the reset macro.")))

(defmacro shift [k & body]
  `(shift* (fn [~k] ~@body)))

(defmethod transform :shift* [cons k-expr]
  (when-not (= (count cons) 2)
    (throw (Exception. "Please ensure shift has one argument.")))
  `(~(first (rest cons)) ~k-expr))

snip

(defmacro reset [& body]
  (binding [*ctx* (Context. nil)]
    (expr-sequence->cps body identity)))

