;; when evaluated at the macro level:
(if (= 2 (+ 1 1))
  (do (print "You got")
      (print " the touch!")
      (println)))

;; and when later evaluated as code:
;You got the touch!
;=> nil
