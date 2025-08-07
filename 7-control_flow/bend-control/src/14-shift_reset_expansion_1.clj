#_{:clj-kondo/ignore [:refer-all]}
(require '[delimc.core :refer :all])

(macroexpand '(reset 1))
; (#object[clojure.core$identity 0x3c09f4b2 "clojure.core$identity@3c09f4b2"] 1)

(reset 1)
; 1

(macroexpand '(reset 1 2))
;; ((clojure.core/fn
;;   [r__2587__auto__ & rest-args__2588__auto__]
;;   (#object[clojure.core$identity 0x3c09f4b2 "clojure.core$identity@3c09f4b2"]
;;    2))
;;  1)

(reset 1 2)
; 2

(macroexpand '(reset (shift k (k 1))))
;; ((clojure.core/fn [k] (k 1))
;;  #object[clojure.core$identity 0x3c09f4b2 "clojure.core$identity@3c09f4b2"])

#_{:clj-kondo/ignore [:unresolved-symbol]}
(reset (shift k (k 1)))
; 1
