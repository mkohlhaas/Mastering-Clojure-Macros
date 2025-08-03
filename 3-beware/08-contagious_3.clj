(defmacro notify-everyone [messages]
  `(do
     (send-email admin-user ~messages)
     (send-email current-user ~messages)
     (log ~@messages)))

(notify-everyone ["item #1 processed" "by worker #72"])
; (out) [INFO] item #1 processed : by worker #72

#_{:clj-kondo/ignore [:unresolved-var]}
; macroexpand-1 (form): (notify-everyone ["item #1 processed" "by worker #72"])
(do
  (user/send-email user/admin-user   ["item #1 processed" "by worker #72"])
  (user/send-email user/current-user ["item #1 processed" "by worker #72"])
  (user/log "item #1 processed" "by worker #72"))
; (out) [INFO] item #1 processed : by worker #72
