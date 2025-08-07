;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Implement New Language Features
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Implementing Pattern Matching
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; desired API (using vectors so we can match multiple things later on):
#_{:clj-kondo/ignore [:unresolved-symbol]}
(match [x]
  [0] :zero
  [1] :one
  :else :foo)

;; desired macroexpansion:
#_{:clj-kondo/ignore [:unresolved-symbol]}
(cond (= [x] [0]) :zero
      (= [x] [1]) :one
      :else :foo)

;; expected outcomes
#_{:clj-kondo/ignore [:unresolved-symbol]}
(describe "pattern matching"
          (it "matches an int"
    ;; will only compile once we've written `match`
              (let [match-simple-int-input (fn [n]
                                             (match [n]
                                               [0] :zero
                                               [1] :one
                                               [2] :two
                                               :else :other))]
                (should= :zero (match-simple-int-input 0))
                (should= :one (match-simple-int-input 1))
                (should= :two (match-simple-int-input 2))
                (should= :other (match-simple-int-input 3)))))
