(defmacro broken-when [test & body]
  (list test (cons 'do body)))

(broken-when (= 1 1) (println "Math works!"))
; (err) java.lang.ClassCastException

((= 1 1) (do (println "Math works!")))
; (err) java.lang.ClassCastException
