(defmacro inspect-called-form [& arguments]
  {:form (list 'quote &form)})

user=> ^{:doc "this is good stuff"} (inspect-called-form 1 2 3)
;=> {:form (inspect-called-form 1 2 3)}
user=> (meta (:form *1))
;=> {:doc "this is good stuff", :line 1, :column 1}
