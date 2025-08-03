;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Advance Your Macro Techniques
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#_{:clj-kondo/ignore [:redefined-var]}
(defmacro assert [x]
  (when *assert* ;; check dynamic var `clojure.core/*assert*` to make sure assertions are enabled; true 
    (list 'when-not x
          (list 'throw
                (list 'new 'AssertionError
                      (list 'str "Assert failed: "
                            (list 'pr-str (list 'quote x)))))))) ; #'user/assert

(assert (= 1 2))
; (err) java.lang.AssertionError: Assert failed: (= 1 2)

#_{:clj-kondo/ignore [:redundant-do]}
; macroexpand (form): (assert (= 1 2))
(if (= 1 2)
  nil
  (do
    (throw
     (new AssertionError (str "Assert failed: " (pr-str '(= 1 2)))))))
; (err) java.lang.AssertionError: Assert failed: (= 1 2)

; macroexpand-1 (form): (assert (= 1 2))
(when-not (= 1 2)
  (throw (new AssertionError (str "Assert failed: " (pr-str '(= 1 2))))))
; (err) java.lang.AssertionError: Assert failed: (= 1 2)

(assert (= 1 1)) ; nil

; macroexpand-1 (form): (assert (= 1 1))
(when-not (= 1 1)
  (throw (new AssertionError (str "Assert failed: " (pr-str '(= 1 1))))))
; nil
