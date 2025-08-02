(defn process-events [events]
  (doseq [event events]
    ;; do some meaningful work based on the event
    (log (format "Event %s has been processed" (:id event)))))

(let [file (java.io.File. (System/getProperty "user.home") "event-stream.log")]
  (with-open [file (clojure.java.io/writer file :append true)]
    (binding [*out* file]
      (process-events [{:id 88896} {:id 88898}]))))

