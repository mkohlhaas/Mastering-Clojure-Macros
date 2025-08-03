;; auto-gensym looks like a reverse hashtag
(defmacro make-adder [x]
  `(fn [y#] (+ ~x y#)))

(def y 100)

;; ✓
((make-adder (+ y 3)) 5) ; 108
