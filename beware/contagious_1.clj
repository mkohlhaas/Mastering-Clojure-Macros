(require '[clojure.string :as string])
(defmacro log [& args]
  `(println (str "[INFO] " (string/join " : " ~(vec args)))))

user=> (log "that went well")
;[INFO] that went well
;=> nil
user=> (log "item #1 created" "by user #42")
; [INFO] item #1 created : by user #42
;=> nil

