;; quote, then unquote in syntax quoting neutralizes but removes namespace qualification
`(* ~'x ~'x) ; (clojure.core/* x x)
