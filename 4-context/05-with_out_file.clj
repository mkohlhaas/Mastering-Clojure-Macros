;; makeing a macro out of the previous let statement in 4-context/04-log_to_file.clj
(defmacro with-out-file [file & body]
  `(with-open [writer# (clojure.java.io/writer ~file :append true)]
     (binding [*out* writer#]
       ~@body)))

(defn log [message]
  (let [timestamp (.format (java.text.SimpleDateFormat. "yyyy-MM-dd'T'HH:mmZ")
                           (java.util.Date.))]
    (println timestamp "[INFO]" message)))

(defn process-events [events]
  (doseq [event events]
    (log (format "Event %s has been processed" (:id event)))))

;; intention is now much clearer
(let [file (java.io.File. (System/getProperty "java.io.tmpdir") "event-stream.log")]
  (with-out-file file
    (process-events [{:id 88894} {:id 88895} {:id 88897}])
    (process-events [{:id 88896} {:id 88898}])))
