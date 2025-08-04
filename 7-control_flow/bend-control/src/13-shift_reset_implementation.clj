;; just sample code - not runnable!

#_{:clj-kondo/ignore [:namespace-name-mismatch]}
;; (ns delimc.core)

#_{:clj-kondo/ignore [:unresolved-symbol]}
snip

(defmulti transform (fn [[op & _forms] _k-expr] (keyword op)))

#_{:clj-kondo/ignore [:unresolved-symbol]}
snip

(defn shift* [_cc]
  (throw (Exception.
          "Please ensure shift is called from within the reset macro.")))

(defmacro shift [k & body]
  `(shift* (fn [~k] ~@body)))

(defmethod transform :shift* [cons k-expr]
  (when-not (= (count cons) 2)
    (throw (Exception. "Please ensure shift has one argument.")))
  `(~(first (rest cons)) ~k-expr))

#_{:clj-kondo/ignore [:unresolved-symbol]}
snip

#_{:clj-kondo/ignore [:unresolved-symbol]}
(defmacro reset [& body]
  (binding [*ctx* (Context. nil)]
    (expr-sequence->cps body identity)))

