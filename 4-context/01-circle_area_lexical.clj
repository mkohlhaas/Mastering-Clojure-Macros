;; ;;;;;;;;;;;;;;;;
;; Dynamic Bindings
;; ;;;;;;;;;;;;;;;;

;; radius is lexically scoped
(defn circle-area [radius]
  (* Math/PI radius radius))

(circle-area 10.0)
; 314.1592653589793
