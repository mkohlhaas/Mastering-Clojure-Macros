(ns foo (:refer-clojure :exclude [map]))
;=> nil
foo=> (def map {:a 1 :b 2})
;=> #'foo/map
foo=> (user/squares (range 10))
;=> (0 1 2 3 4 5 6 7 8 9)
foo=> (user/squares :a)
;=> :a
foo=> (first (macroexpand '(user/squares (range 10))))
;=> map
foo=> ({:a 1 :b 2} :nonexistent-key :default-value)
;=> :default-value
