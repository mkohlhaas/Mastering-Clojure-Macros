(defmacro inspect-caller-locals-1 []
  (->> (keys &env)
       (map (fn [k] [(list 'quote k) k])) ; easy to understand
       (into {})))

(defmacro inspect-caller-locals-2 []
  (->> (keys &env)
       (map (fn [k] [`(quote ~k) k])) ; progression to syntax quoting
       (into {})))

(inspect-caller-locals-2) ; {}

(inspect-caller-locals-1) ; {}

#_{:clj-kondo/ignore [:unused-binding]}
(let [foo "bar" baz "quux"] (inspect-caller-locals-1))
; {foo "bar", baz "quux"}

#_{:clj-kondo/ignore [:unused-binding]}
(let [foo "bar" baz "quux"] (inspect-caller-locals-2))
; {foo "bar", baz "quux"}
