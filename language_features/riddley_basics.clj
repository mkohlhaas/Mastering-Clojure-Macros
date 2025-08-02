(require '[riddley.walk :as walk])

(defn malkovichify [expression]
  (walk/walk-exprs
   symbol?                 ;; predicate: should we run the handler on this?
   (constantly 'malkovich) ;; handler: does any desired replacements
   expression))

(malkovichify '(println a b))
;=> (malkovich malkovich malkovich)

