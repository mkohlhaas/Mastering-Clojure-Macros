(defmacro inspect-called-form [& _arguments]
  {:form (list 'quote &form)})

^{:doc "this is good stuff"} (inspect-called-form 1 2 3)
; {:form (inspect-called-form 1 2 3)}

(meta (:form *1))
; {:line 1, :column 1, :doc "this is good stuff"}
