#_{:clj-kondo/ignore [:redefined-var]}
(defmacro assert [x]
  (when *assert*
    `(when-not ~x
       (throw (new AssertionError (str "Assert failed: " (pr-str '~x)))))))

(assert (= 1 2))
; (err) java.lang.AssertionError: Assert failed: (= 1 2)

; macroexpand-1 (form): (assert (= 1 2))
(clojure.core/when-not (= 1 2)
  (throw
   (new
    java.lang.AssertionError
    (clojure.core/str
     "Assert failed: "
     (clojure.core/pr-str '(= 1 2))))))
; (err) java.lang.AssertionError: Assert failed: (= 1 2)
