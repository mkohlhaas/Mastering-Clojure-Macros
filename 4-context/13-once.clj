(let [x :a
      f (^:once fn* [] (println x))]
  (f)  ;; prints :a
  (f)) ;; prints nil (not any more?)
; (out) :a
; (out) :a

(let [x :a
      f (fn [] (println x))]
  (f)  ;; prints :a
  (f)) ;; prints :a
; (out) :a
; (out) :a
