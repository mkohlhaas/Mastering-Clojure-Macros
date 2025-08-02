(defmacro our-and
  ([] true)
  ([x] x)
  ([x & next]
   `(if ~x (our-and ~@next) ~x)))

user=> (our-and true true)
;=> true
user=> (our-and true false)
;=> false
user=> (our-and true true false)
;=> false
user=> (our-and true true nil)
;=> nil
user=> (our-and 1 2 3)
;=> 3
