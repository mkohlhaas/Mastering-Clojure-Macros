(require '[clojure.string :as string])

;; better solution is just to use a function
(defn log [& args]
  (println (str "[INFO] " (string/join " : " args))))

(log "hi" "there")
;[INFO] hi : there
;=> nil

(apply log ["hi" "there"])
; (out) [INFO] hi : there
