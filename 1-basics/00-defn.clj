;; ;;;;;;;;;;;;
;; Code Is Data
;; ;;;;;;;;;;;;

(defn mapcat
  "Returns the result of applying concat to the result of applying map
  to f and colls.  Thus function f should return a collection."
  {:added "1.0"
   :static true}
  [f & colls]
  (apply concat (apply map f colls)))

(mapcat reverse [[3 2 1 0] [6 5 4] [9 8 7]])
; (0 1 2 3 4 5 6 7 8 9)

(mapcat (fn [[k v]]
          (for [[k2 v2] v]
            (concat [k k2] v2)))
        '{:a {:x (1 2) :y (3 4)}
          :b {:x (1 2) :z (5 6)}})
; ((:a :x 1 2) (:a :y 3 4) (:b :x 1 2) (:b :z 5 6))
