(defn merge [xs ys]
  (loop [acc [] xs xs ys ys]
    (match [(seq xs) (seq ys)]
      [nil b] (concat acc b)
      [a nil] (concat acc a)
      [[x & x-rest] [y & y-rest]]
      (if (< x y)
        (recur (conj acc x) x-rest ys)
        (recur (conj acc y) xs y-rest)))))

(it "implements merge (from merge-sort)"
    (should= [1 2 3] (merge [1 2 3] []))
    (should= [1 2 3] (merge [1 2 3] nil))
    (should= [1 2 3 4] (merge [1 2 3] [4]))
    (should= [1 2 3] (merge [] [1 2 3]))
    (should= [1 2 3] (merge nil [1 2 3]))
    (should= [1 2 3 4 5 6 7] (merge [1 3 4 7] [2 5 6])))

