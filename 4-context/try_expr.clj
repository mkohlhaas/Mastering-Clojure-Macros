(defmacro try-expr [msg form]
  `(try ~(assert-expr msg form)
        (catch Throwable t#
          (do-report {:type :error, :message ~msg,
                      :expected '~form, :actual t#}))))
(defmacro is
  ([form] `(is ~form nil))
  ([form msg] `(try-expr ~msg ~form)))
