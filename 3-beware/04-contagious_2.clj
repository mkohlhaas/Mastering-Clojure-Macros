;; this would send email in a real implementation
(defn send-email [_user _messages]
  (Thread/sleep 1000))

(def admin-user   "kathy@example.com")
(def current-user "colin@example.com")

(defmacro log [& args]
  `(println (str "[INFO] " (string/join " : " ~(vec args)))))

(defn notify-everyone [messages]
  (apply log messages)
  (send-email admin-user   messages)
  (send-email current-user messages))
; (err) java.lang.IllegalStateException: Can't take value of a macro: #'user/log
