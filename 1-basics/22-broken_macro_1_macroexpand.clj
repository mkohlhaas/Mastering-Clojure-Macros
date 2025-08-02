(macroexpand-1
 '(broken-when (= 1 1) (println "Math works!")))
; ((= 1 1) (do (println "Math works!")))
