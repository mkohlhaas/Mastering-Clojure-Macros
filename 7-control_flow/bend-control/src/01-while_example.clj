(def counter (atom 0))

(while (< @counter 3)
  (println @counter)
  (swap! counter inc))
; (out) 0
; (out) 1
; (out) 2
