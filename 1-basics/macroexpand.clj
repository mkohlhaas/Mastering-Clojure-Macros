(defmacro when-falsy [test & body]
  (list 'when (list 'not test)
        (cons 'do body)))

(macroexpand-1 '(when-falsy (= 1 2) (println "hi!")))
;=> (when (not (= 1 2)) (do (println "hi!")))

(macroexpand '(when-falsy (= 1 2) (println "hi!")))
;=> (if (not (= 1 2)) (do (do (println "hi!"))))
