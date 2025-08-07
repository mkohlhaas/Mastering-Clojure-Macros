;; extracts from delimc.core

;; (ns delimc.core)

(defmulti transform (fn [[op & _forms] _k-expr] (keyword op)))

(defn shift* [_cc]
  (throw (Exception. "Please ensure shift is called from within the reset macro.")))

#_{:clojure-lsp/ignore [:clojure-lsp/unused-public-var]}
(defmacro shift [k & body]
  `(shift* (fn [~k] ~@body)))

(defmethod transform :shift* [cons k-expr]
  (when-not (= (count cons) 2)
    (throw (Exception. "Please ensure shift has one argument.")))
  `(~(first (rest cons)) ~k-expr))

#_{:clj-kondo/ignore [:unresolved-symbol]}
#_{:clojure-lsp/ignore [:clojure-lsp/unused-public-var]}
(defmacro reset [& body]
  (binding [*ctx* (Context. nil)]
    (expr-sequence->cps body identity)))

