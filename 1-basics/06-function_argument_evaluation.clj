(defn print-with-asterisks [printable-argument]
  (print "*****")
  (print printable-argument)
  (println "*****"))

(print-with-asterisks "hi") ; nil
; (out) *****hi*****
