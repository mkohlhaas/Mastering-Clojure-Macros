;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Implement New Language Features
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Implementing Pattern Matching
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; this file just specifies what we want (implementations follow in subsequent files)

(ns features.pattern-matching.pattern-matching-1)

#_{:clj-kondo/ignore [:unresolved-symbol]}
;; NOTE: desired API (using vectors so we can match multiple things later on):
(match [x]
  [0] :zero
  [1] :one
  :else :foo)

#_{:clj-kondo/ignore [:unresolved-symbol]}
;; NOTE: desired macroexpansion:
(cond (= [x] [0]) :zero
      (= [x] [1]) :one
      :else :foo)
