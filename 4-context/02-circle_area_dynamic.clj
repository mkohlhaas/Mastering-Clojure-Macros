(declare ^:dynamic *radius*)

(defn circle-area []
  (* Math/PI *radius* *radius*))

(binding [*radius* 10.0]
  (circle-area))
; 314.1592653589793
