;; using a macro (->>)
;; &env is special
(defmacro inspect-caller-locals []
  (->> (keys &env)
       (map (fn [k] [`'~k k]))
       (into {})))

(inspect-caller-locals) ; {}

#_{:clj-kondo/ignore [:unused-binding]}
(let [foo "bar" baz "quux"] (inspect-caller-locals))
; {baz "quux", foo "bar"}
