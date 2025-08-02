(defmacro choice [xs]
  `(shift k# (mapcat k# ~xs)))

(def return list)

(defmacro insist [p]
  `(when-not ~p (choice [])))

(let [numbers (range 1 20)
      square (fn [x] (* x x))]
  (reset
   (return
    (let [a (choice numbers)
          b (choice numbers)
          c (choice numbers)]
      (insist (< a b c))
      (insist (= (square c) (+ (square a) (square b))))
      [a b c]))))
;=> ([3 4 5] [5 12 13] [6 8 10] [8 15 17] [9 12 15])
