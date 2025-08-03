(let [x :a
      f (fn [] (println x))]
  (f)  ;; prints :a
  (f)) ;; prints :a
; (out) :a
; (out) :a

;; `^:keyword` is a shorthand for `^{:keyword true}`
(let [x :a
      f (^:once fn* [] (println x))]
  (f)  ;; prints :a
  (f)) ;; prints nil (NOTE: not any more?)
; (out) :a
; (out) :a (NOTE: ???)

(println)
