(with-redefs [< +] (< 1 2))
;=> true

(with-redefs [< +] (apply < [1 2]))
;=> 3
