(macroexpand '(reset 1))
;=> (#<core$identity clojure.core$identity@750a6c68> 1)

(reset 1)
;=> 1

(macroexpand '(reset 1 2))
;=> ((clojure.core/fn [r__1247__auto__ & rest-args__1248__auto__]
;      (#<core$identity clojure.core$identity@750a6c68> 2))
;    1)

(reset 1 2)
;=> 2

(macroexpand '(reset (shift k (k 1))))
;=> ((clojure.core/fn [k] (k 1))
;    #<core$identity clojure.core$identity@750a6c68>)

(reset (shift k (k 1)))
;=> 1
