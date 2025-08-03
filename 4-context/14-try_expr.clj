;; ;;;;;;;;;;;;;;;
;; Rescuing Errors
;; ;;;;;;;;;;;;;;;

(require '[clojure.test :as test])

;; In clojure.test the `is` macro uses an internal macro try-expr 
;; to catch exceptions and report them to the test-running infrastructure.

;; catches unexpected exceptions so that tests can continue and reports those errors
(defmacro try-expr [msg form]
  `(try ~(test/assert-expr msg form)
        (catch Throwable t#
          (test/do-report {:type :error,
                           :message ~msg,
                           :expected '~form,
                           :actual t#}))))
(defmacro is
  ([form]     `(is ~form nil))
  ([form msg] `(try-expr ~msg ~form)))
