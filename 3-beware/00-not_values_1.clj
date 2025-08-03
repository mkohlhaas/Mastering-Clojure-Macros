;; ;;;;;;;;;;;;;;;;;;;;;;
;; Use Your Powers Wisely
;; ;;;;;;;;;;;;;;;;;;;;;;

;; ;;;;;;;;;;;;;;;;;;;;
;; Macros Aren’t Values
;; ;;;;;;;;;;;;;;;;;;;;

;; Function

(defn square [x] (* x x))

;; ✓
(map square (range 10))
; (0 1 4 9 16 25 36 49 64 81)

;; Macro

#_{:clj-kondo/ignore [:redefined-var]}
(defmacro square [x] `(* ~x ~x))

;; ✗
(map square (range 10))
; (err) java.lang.IllegalStateException: Can't take value of a macro
