(-> "hi")
; "hi"

; clojure.walk/macroexpand-all (form): (-> "hi")
;; "hi"

(-> 4
    (+ 3)
    (* 2))
; 14

; macroexpand-1 (form): (-> 4↵    (+ 3)↵    (* 2))
;; (* (+ 4 3) 2)

(-> 10
    ^clojure.lang.LazySeq range
    .iterator
    (doto .next .next)
    .next)
;=> ???

; macroexpand-1 (form): (-> 10↵    ^clojure.lang.LazySeq range↵    .iterator↵    (doto .next .next)↵    .next)
;; (.next
;;     (doto
;;         (.iterator
;;             (range 10)))
;;     .next .next)
