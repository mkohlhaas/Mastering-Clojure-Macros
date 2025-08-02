(defmacro our-and
  ([] true)
  ([x] x)
  ([x & next]
   `(if ~x (our-and ~@next) ~x)))

(our-and true true)
;=> true
(our-and true false)
;=> false
(our-and true true false)
;=> false
(our-and true true nil)
;=> nil
(our-and 1 2 3)
;=> 3
