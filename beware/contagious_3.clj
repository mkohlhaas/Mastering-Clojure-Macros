(defmacro notify-everyone [messages]
  `(do
     (send-email admin-user ~messages)
     (send-email current-user ~messages)
     (log ~@messages)))

user=> (notify-everyone ["item #1 processed" "by worker #72"])
;[INFO] item #1 processed : by worker #72
;=> nil

