(ns features.pattern-matching.pattern-matching-1a)

(defmacro match [input & more]
  (let [clauses (partition 2 more)]
    `(cond
       ~@(mapcat (fn [[match-expression result]]
                   (if (= :else match-expression)
                     [:else result]                           ; special :else case injected into output
                     [`(= ~input ~match-expression) result])) ; insert this line into the output (syntax quoting inside syntax quoting)
                 clauses))))

;; clauses => (([0] :zero) ([1] :one) ([2] :two) (:else :other))

(mapcat reverse [[3 2 1 0] [6 5 4] [9 8 7]])
; (0 1 2 3 4 5 6 7 8 9)

;; #_{:clj-kondo/ignore [:unresolved-symbol]}
;; (match [x]
;;   [0] :zero
;;   [1] :one
;;   :else :foo)

;; #_{:clj-kondo/ignore [:unresolved-symbol]}
;; macroexpand-1 (form): (match [x]↵  [0] :zero↵  [1] :one↵  :else :foo)
;; (clojure.core/cond
;;   (clojure.core/= [x] [0]) :zero
;;   (clojure.core/= [x] [1]) :one
;;   :else :foo)
