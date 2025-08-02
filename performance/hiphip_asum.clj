;; from hiphip/type_impl.clj
(defmacro asum
  ([array]
   `(asum [a# ~array] a#))
  ([bindings form]
   `(areduce ~bindings sum# ~(impl/value-cast +type+ 0) (+ sum# ~form))))
