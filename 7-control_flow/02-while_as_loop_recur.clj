(def counter (atom 0))

(loop []
  (when (< @counter 3)
    (println @counter)
    (swap! counter inc)
    (recur)))
; 0
; 1
; 2
;=> nil

