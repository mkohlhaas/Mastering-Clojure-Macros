(macroexpand-1 '(when (= 1 2) (println "math is broken")))
;=> (if (= 1 2) (do (println "math is broken")))

(macroexpand-1 nil)
;=> nil

(macroexpand-1 '(+ 1 2))
;=> (+ 1 2)
