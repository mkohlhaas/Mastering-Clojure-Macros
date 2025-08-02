(let [expression (+ 1 2 3 4 5)] ;; expression is bound to 15
  (cons
   (read-string "*")    ;; *
   (rest expression)))  ;; (rest 15)
; IllegalArgumentException Don't know how to create ISeq from: java.lang.Long
;   clojure.lang.RT.seqFrom (RT.java:505)

