(require '[clojure.string :as string])
(defn log [& args]
  (println (str "[INFO] " (string/join " : " args))))

(log "hi" "there")
;[INFO] hi : there
;=> nil

(apply log ["hi" "there"])
;[INFO] hi : there
;=> nil

