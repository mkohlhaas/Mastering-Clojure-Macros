(macroexpand-1 '(our-and (do (println "hi there") (= 1 2)) (= 3 4)))
; (if
;  (do (println "hi there") (= 1 2))
;  (user/our-and (= 3 4))
;  (do (println "hi there") (= 1 2)))
