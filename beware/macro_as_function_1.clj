(defmacro square [x] `(* ~x ~x))
;=> #'user/square
@#'square
;=> #<user$square user$square@2a717ef5>
(fn? @#'square)
;=> true
