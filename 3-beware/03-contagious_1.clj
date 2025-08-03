;; ;;;;;;;;;;;;;;;;;;;;;;;;
;; Macros Can Be Contagious
;; ;;;;;;;;;;;;;;;;;;;;;;;;

(require '[clojure.string :as string])

;; ;;;;;;;;;;;
;; 1st version
;; ;;;;;;;;;;;

;; converts list (= &args) into a vector which can be iterated over by `join`
(defmacro log [& args]
  `(println (str "[INFO] " (string/join " : " ~(vec args)))))

(log "that went well")
; (out) [INFO] that went well

(log "item #1 created" "by user #42")
; (out) [INFO] item #1 created : by user #42

;; ;;;;;;;;;;;
;; 2nd version
;; ;;;;;;;;;;;

(defmacro log-1 [& args]
  `(println (str "[INFO] " (string/join " : " '~args))))

(log-1 "that went well")
; (out) [INFO] that went well

(log-1 "item #1 created" "by user #42")
; (out) [INFO] item #1 created : by user #42

;; ;;;;;;;;;;;
;; 3rd version
;; ;;;;;;;;;;;

;; ~args expands to a list with first item - a string - trying to make a function call
(defmacro log-bad [& args]
  `(println (str "[INFO] " (string/join " : " ~args))))

(log-bad "that went well")
; (err) java.lang.ClassCastException: java.lang.String cannot be cast to clojure.lang.IFn

(log-bad "item #1 created" "by user #42")
; (err) java.lang.ClassCastException: java.lang.String cannot be cast to clojure.lang.IFn
