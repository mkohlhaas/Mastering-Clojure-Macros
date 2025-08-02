(require '[clojure.test :refer [is]])
(is (= 1 1))
;=> true

(is (= 1 (do (throw (Exception.)) 1)))
; ERROR in clojure.lang.PersistentList$EmptyList@1 (NO_SOURCE_FILE:1)
; expected: (= 1 (do (throw (Exception.)) 1))
;   actual: java.lang.Exception: null
;=> nil

