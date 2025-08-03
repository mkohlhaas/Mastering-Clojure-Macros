;; (declare ^:dynamic *radius*)

(def ^:dynamic *radius* 10.0) ; default radius of 10.0

;; radius is dynamically scoped
(defn circle-area []
  (* Math/PI *radius* *radius*))

(circle-area)
; 314.1592653589793

;; radius is temporarily changed with `binding`
(binding [*radius* 1.0]
  (circle-area))
; 3.141592653589793
