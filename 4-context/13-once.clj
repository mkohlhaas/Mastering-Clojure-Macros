(let [x :a
      f (^:once fn* [] (println x))]
  (f)  ;; prints :a
  (f)) ;; prints nil

(let [x :a
      f (fn [] (println x))]
  (f)  ;; prints :a
  (f)) ;; prints :a
