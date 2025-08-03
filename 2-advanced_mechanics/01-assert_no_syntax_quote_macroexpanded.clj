;; `macroexpand` is a function -> expression needs quotation!
(macroexpand '(assert (= 1 2)))
; (if
;  (= 1 2)
;  nil
;  (do
;   (throw
;    (new AssertionError (str "Assert failed: " (pr-str '(= 1 2)))))))
