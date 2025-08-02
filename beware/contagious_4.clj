(require '[clojure.string :as string])
(defn log [& args]
  (println (str "[INFO] " (string/join " : " args))))

user=> (log "hi" "there")
;[INFO] hi : there
;=> nil

user=> (apply log ["hi" "there"])
;[INFO] hi : there
;=> nil

