(defmacro when
  "Evaluates test. If logical true, evaluates body in an implicit do."
  {:added "1.0"}
  [test & body]
  (list 'if test (cons 'do body)))

(when (= 2 (+ 1 1))
  (print "You got")
  (print " the touch!")
  (println)) ; nil
; (out) You got the touch!

(if (= 2 (+ 1 1))
  (do (print "You got") (print " the touch!") (println)))
; (out) You got the touch!
