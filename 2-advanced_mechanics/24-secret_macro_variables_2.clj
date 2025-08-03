;; using a macro (->>)
;; get a map of local names to local values
(defmacro inspect-caller-locals []
  (->> (keys &env)
       ;; (map (fn [k] [`'~k k])) ; `'~k is equal to `(quote ~k) and (list 'quote k)
       (map (fn [k] [`'~k k])) ; `'~k is equal to `(quote ~k) and (list 'quote k)
       (into {})))

(inspect-caller-locals) ; {}

#_{:clj-kondo/ignore [:unused-binding]}
(let [foo "bar" baz "quux"] (inspect-caller-locals))
; {baz "quux", foo "bar"}
