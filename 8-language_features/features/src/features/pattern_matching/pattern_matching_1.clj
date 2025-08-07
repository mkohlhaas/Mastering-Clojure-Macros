;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Implement New Language Features
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Implementing Pattern Matching
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns features.pattern-matching.pattern-matching-1)

(defmacro match [input & more]
  (let [clauses (partition 2 more)]
    `(cond
       ~@(mapcat (fn [[match-expression result]]
                   (if (= :else match-expression)
                     [:else result]
                     [`(= ~input ~match-expression)
                      result]))
                 clauses))))

;; desired API (using vectors so we can match multiple things later on):
;; #_{:clj-kondo/ignore [:unresolved-symbol]}
;; (match [x]
;;   [0] :zero
;;   [1] :one
;;   :else :foo)

;; desired macroexpansion:
;; #_{:clj-kondo/ignore [:unresolved-symbol]}
;; (cond (= [x] [0]) :zero
;;       (= [x] [1]) :one
;;       :else :foo)

;; (clojure.core/cond
;;   (clojure.core/= [x] [0]) :zero
;;   (clojure.core/= [x] [1]) :one
;;   :else :foo)

;; expected outcomes
;; (describe "pattern matching"
;;           (it "matches an int"
;;     ;; will only compile once we've written `match`
;;               (let [match-simple-int-input (fn [n]
;;                                              (match [n]
;;                                                [0] :zero
;;                                                [1] :one
;;                                                [2] :two
;;                                                :else :other))]
;;                 (should= :zero (match-simple-int-input 0))
;;                 (should= :one (match-simple-int-input 1))
;;                 (should= :two (match-simple-int-input 2))
;;                 (should= :other (match-simple-int-input 3)))))
