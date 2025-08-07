;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Bend Control Flow to Your Will
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Loops and Loops and Loops and…
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#_{:clj-kondo/ignore [:redefined-var]}
(defmacro while
  "Repeatedly executes body while test expression is true. Presumes
  some side-effect will cause test to become false/nil. Returns nil"
  {:added "1.0"}
  [test & body]
  `(loop []
     (when ~test
       ~@body
       (recur))))
