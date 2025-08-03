(defmacro do-while [test & body]
  `(loop []
     ~@body
     (when ~test (recur))))

(defn play-game [secret]
  (let [guess (atom nil)]
    (do-while (not= (str secret) (str @guess))
              (print "Guess the secret I'm thinking: ")
              (flush)
              (reset! guess (read-line)))
    (println "You got it!")))

(play-game "zebra")
; Guess the secret I'm thinking: lion
; Guess the secret I'm thinking: zebra
; You got it!
