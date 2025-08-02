(macroexpand '(assert (= 1 2)))
;=> (if (= 1 2)
;     nil
;     (do (throw (new AssertionError
;                  (str "Assert failed: "
;                       (pr-str (quote (= 1 2))))))))
;;; [indentation for clarity]
