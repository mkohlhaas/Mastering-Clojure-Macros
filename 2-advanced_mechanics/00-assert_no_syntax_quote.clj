(defmacro assert [x]
  (when *assert* ;; check the dynamic var `clojure.core/*assert*` to make sure assertions are enabled
    (list 'when-not x
          (list 'throw
                (list 'new 'AssertionError
                      (list 'str "Assert failed: "
                            (list 'pr-str (list 'quote x)))))))) ; #'user/assert

(assert (= 1 2))
; (err) java.lang.AssertionError: Assert failed: (= 1 2)

(when-not (= 1 2)
  (throw (new AssertionError (str "Assert failed: " (pr-str '(= 1 2))))))
; (err) java.lang.AssertionError: Assert failed: (= 1 2)

(assert (= 1 1)) ; nil
