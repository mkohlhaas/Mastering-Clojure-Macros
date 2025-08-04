#_{:clj-kondo/ignore [:refer-all]}
(require '[delimc.core :refer :all])

(macroexpand '(reset (+ 1 (shift k (k 1)))))
;=> ((clojure.core/fn [G__2268 & rest-args__1225__auto__]
;      ((clojure.core/fn [G__2269 & rest-args__1225__auto__]
;         ((clojure.core/fn [k] (k 1))
;          (clojure.core/fn [G__2270 & rest-args__1225__auto__]
;            (delimc.core/funcall-cc
;              G__2268
;              #<core$identity clojure.core$identity@750a6c68>
;              G__2269
;              G__2270))))
;       1))
;    (delimc.core/function +))

#_{:clj-kondo/ignore [:unresolved-symbol]}
(reset (+ 1 (shift k (k 1))))
;=> 2
