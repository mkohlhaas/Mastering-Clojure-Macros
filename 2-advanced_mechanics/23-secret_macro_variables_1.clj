(require '[clojure.pprint :refer [pprint]])

;; &form and &env are special
(defmacro info-about-caller []
  (pprint {:form &form :env &env})
  `(println "macro was called!"))

(info-about-caller)
; (out) {:form (info-about-caller), :env {}}
; (out) macro was called!

(let [foo "bar"] (info-about-caller))
; (out) {:form (info-about-caller), :env {foo G__688}}
; (out) macro was called!

(let [foo "bar" baz "quux"] (info-about-caller))
; (out) {:form (info-about-caller), :env {foo G__691, baz G__692}}
; (out) macro was called!
