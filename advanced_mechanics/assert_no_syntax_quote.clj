(defmacro assert [x]
  (when *assert* ;; check the dynamic var `clojure.core/*assert*` to make sure
                 ;;   assertions are enabled
    (list 'when-not x
          (list 'throw
                (list 'new 'AssertionError
                      (list 'str "Assert failed: "
                            (list 'pr-str (list 'quote x))))))))

user=> (assert (= 1 2))
;=> AssertionError Assert failed: (= 1 2)  user/eval214 (NO_SOURCE_FILE:1)

user=> (assert (= 1 1))
;=> nil

