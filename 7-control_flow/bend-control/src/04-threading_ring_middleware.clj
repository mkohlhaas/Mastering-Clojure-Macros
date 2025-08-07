;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Turning Expressions Inside Out with Threading Macros
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Example code for Ring middleware - not runnable!

#_{:clj-kondo/ignore [:unresolved-symbol]}
(def app-1
  (wrap-head
   (wrap-file-info
    (wrap-resource (wrap-session
                    (wrap-flash
                     (wrap-params app-handler)))
                   "public"))))

#_{:clj-kondo/ignore [:unresolved-symbol]}
;; The ,,, placeholders represent the result from the previous line
(def app-2
  (-> app-handler                 ;; app-handler
      wrap-params                 ;; (wrap-params ,,,)
      wrap-flash                  ;; (wrap-flash ,,,)
      wrap-session                ;; (wrap-session ,,,)
      (wrap-resource "public")    ;; (wrap-resource ,,, "public")
      wrap-file-info              ;; (wrap-file-info ,,,)
      wrap-head))                 ;; (wrap-head ,,,)

;; clojure.walk/macroexpand-all (form): (-> app-handler)                 ;; app-handler↵      wrap-params                 ;; (wrap-params ,,,)↵      wrap-flash                  ;; (wrap-flash ,,,)↵      wrap-session                ;; (wrap-session ,,,)↵      (wrap-resource "public")    ;; (wrap-resource ,,, "public")↵      wrap-file-info              ;; (wrap-file-info ,,,)↵      wrap-head)
;; (wrap-head
;;  (wrap-file-info
;;   (wrap-resource
;;    (wrap-session 
;;     (wrap-flash
;;       (wrap-params app-handler)))
;;   "public")))
