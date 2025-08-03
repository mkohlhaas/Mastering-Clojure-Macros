(-> "hi") ; "hi"

(-> 4
    (+ 3)
    (* 2))
; 14

(-> 10
    ^clojure.lang.LazySeq range
    .iterator
    (doto .next .next)
    .next)
;=> ???
