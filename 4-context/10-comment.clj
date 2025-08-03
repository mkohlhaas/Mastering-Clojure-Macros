;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Evaluating (or Not) in Time and Place
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#_{:clj-kondo/ignore [:redefined-var]}
(defmacro comment
  "Ignores body, yields nil"
  {:added "1.0"}
  [& _body])

;; Since it’s a macro, the code passed in has to be syntactically
;; correct so that it is readable. One upside of using the comment macro
;; is that you get syntax highlighting in your editor of choice. 
(comment
  (println "wow")
  (println "this macro is incredible"))
;=> nil

(+ 1 2) ; this is another type of comment
(+ 1 2) #_(println "this is yet another")
