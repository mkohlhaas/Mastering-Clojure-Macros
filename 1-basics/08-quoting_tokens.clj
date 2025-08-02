;; ;;;;;;;;;;;;;;;;;;;;;;
;; numbers are themselves
;; ;;;;;;;;;;;;;;;;;;;;;;
(quote 1)
; 1

1 ; 1

;; ;;;;;;;;;;;;;;;;;;;;;;
;; strings are themselves
;; ;;;;;;;;;;;;;;;;;;;;;;
(quote "hello")
; "hello"

"hello" ; "hello"

;; ;;;;;;;;;;;;;;;;;;;;;;;
;; keywords are themselves
;; ;;;;;;;;;;;;;;;;;;;;;;;
(quote :kthx)
; :kthx

:kthx ; :kthx

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;
;; symbols are NOT themselves
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;
(quote kthx)
; kthx

kthx ; (err) Unresolved symbol: kthx

