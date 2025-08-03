(defmacro our-and
  ([] true)
  ([x] x)
  ([x & next]
   `(if ~x (our-and ~@next) ~x)))

;; passing an expression
;; (do ...) will be evaluated twice.
(our-and (do (println "hi there")
             (= 1 2))
         (= 3 4)) ; false
; (out) hi there
; (out) hi there

; clojure.walk/macroexpand-all (form): (our-and (do (println "hi there") (= 1 2)) (= 3 4))
(if (do (println "hi there") (= 1 2)) ; printed
  (= 3 4)
  (do (println "hi there") (= 1 2)))  ; printed again
