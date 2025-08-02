user=> (defmacro square [x] `(* ~x ~x))
;=> #'user/square
user=> @#'square
;=> #<user$square user$square@2a717ef5>
user=> (fn? @#'square)
;=> true
