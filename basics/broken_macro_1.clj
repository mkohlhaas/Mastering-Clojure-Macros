(defmacro broken-when [test & body]
  (list test (cons 'do body)))

(broken-when (= 1 1) (println "Math works!"))
; ClassCastException java.lang.Boolean cannot be cast to clojure.lang.IFn
;   user/eval316 (NO_SOURCE_FILE:1)

