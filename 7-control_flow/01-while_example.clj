(def counter (atom 0))

(while (< @counter 3)
  (println @counter)
  (swap! counter inc))
; 0
; 1
; 2
;=> nil
