;; ascending another ladder rung, treating `when` as a function:
(list 'if 'clauses
      (cons 'do
            '((list 'if (first clauses)
                    (if (next clauses)
                      (second clauses)
                      (throw (IllegalArgumentException.
                              "cond requires an even number of forms")))
                    (cons 'clojure.core/cond (next (next clauses)))))))

