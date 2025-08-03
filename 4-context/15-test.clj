(require '[clojure.test :refer [is]])

(is (= 1 1))
; true

;; Exception is caught, but no error reporting (???)
(is (= 1 (do (throw (Exception.)) 1)))
