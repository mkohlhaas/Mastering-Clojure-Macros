#_{:clj-kondo/ignore [:refer-all]}
(require '[delimc.core :refer :all])

(defmacro choice [xs]
  `(shift k# (mapcat k# ~xs)))

(def return list)

(defmacro insist [p]
  `(when-not ~p (choice [])))

(let [numbers (range 1 40)
      square (fn [x] (* x x))]
  (reset
   (return
    (let [a (choice numbers)
          b (choice numbers)
          c (choice numbers)]
      (insist (< a b c))
      (insist (= (square c) (+ (square a) (square b))))
      [a b c]))))
;; ([3 4 5]
;;  [5 12 13]
;;  [6 8 10]
;;  [7 24 25]
;;  [8 15 17]
;;  [9 12 15]
;;  [10 24 26]
;;  [12 16 20]
;;  [12 35 37]
;;  [15 20 25]
;;  [15 36 39]
;;  [16 30 34]
;;  [18 24 30]
;;  [20 21 29]
;;  [21 28 35])
