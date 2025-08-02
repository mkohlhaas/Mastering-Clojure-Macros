(defmacro our-and
  ([] true)
  ([x] x)
  ([x & next]
   `(if ~x (our-and ~@next) ~x)))

(defmacro our-and-fixed
  ([] true)
  ([x] x)
  ([x & next]
   `(let [arg# ~x]
      (if arg# (our-and-fixed ~@next) arg#))))

(our-and-fixed (do (println "hi there") (= 1 2)) (= 3 4))
;hi there
;=> false
