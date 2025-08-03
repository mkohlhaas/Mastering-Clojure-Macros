(require '[clojure.test :as test])

(defn try-expr [msg f]
  (try (eval (test/assert-expr msg (f)))
       (catch Throwable t
         (test/do-report {:type :error, :message msg,
                          :expected f, :actual t}))))

(defn our-is
  ([f] (our-is (f) nil))
  ([f msg] (test/try-expr msg f)))

(our-is (fn [] (= 1 1)))
; true

(our-is (fn [] (= 1 2)))
; false
; don't see any fail:
; FAIL in clojure.lang.PersistentList$EmptyList@1 (NO_SOURCE_FILE:3)
; expected: f
;   actual: false
