'(a b c) ; (a b c)

;; With the syntax-quoted version, the symbols all include the namespaces
;; where the syntax-quote appears!
;; We say that these symbols are NAMESPACE-QUALIFIED. 
`(a b c) ; (user/a user/b user/c)
