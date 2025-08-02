(defn print-with-asterisks [printable-argument]
  (print "*****")
  (print printable-argument)
  (println "*****"))

(print-with-asterisks
 (do (println "in argument expression")
     "hi")) ; nil
; (out) in argument expression
; (out) *****hi*****
