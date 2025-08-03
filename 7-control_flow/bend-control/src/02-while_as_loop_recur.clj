(def counter (atom 0))

(loop []
  (when (< @counter 3)
    (println @counter)
    (swap! counter inc)
    (recur)))
; (out) 0
; (out) 1
; (out) 2
