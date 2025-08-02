(defmacro inspect-called-form [& arguments]
  {:form (list 'quote (cons 'inspect-called-form arguments))})

user=> (inspect-called-form 1 2 3)
;=> {:form (inspect-called-form 1 2 3)}
