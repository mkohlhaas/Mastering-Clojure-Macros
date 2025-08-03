;; this is what '~ amounts to, unquote then quote
`(1 2 3 (quote (clojure.core/unquote a)) 5) ; (1 2 3 '4 5)
