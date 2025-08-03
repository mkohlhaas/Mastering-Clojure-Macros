(defmacro inspect-caller-locals-1 []
  (->> (keys &env)
       (map (fn [k] [`(quote ~k) k]))
       (into {})))

(defmacro inspect-caller-locals-2 []
  (->> (keys &env)
       (map (fn [k] [(list 'quote k) k]))
       (into {})))

(inspect-caller-locals-1) ; {}

(inspect-caller-locals-2) ; {}

#_{:clj-kondo/ignore [:unused-binding]}
(let [foo "bar" baz "quux"] (inspect-caller-locals-1))
; {foo "bar", baz "quux"}

#_{:clj-kondo/ignore [:unused-binding]}
(let [foo "bar" baz "quux"] (inspect-caller-locals-2))
; {foo "bar", baz "quux"}
