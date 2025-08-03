#_{:clj-kondo/ignore [:redefined-var]}
(defmacro comment
  "Ignores body, yields nil"
  {:added "1.0"}
  [& _body])

(comment
  (println "wow")
  (println "this macro is incredible"))
;=> nil

(+ 1 2) ; this is another type of comment
(+ 1 2) #_(println "this is yet another")
