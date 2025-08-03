(require '[clojure.java.io :as io])

;; `println` uses `*out*`
(defn log [message]
  (let [timestamp (.format (java.text.SimpleDateFormat. "yyyy-MM-dd'T'HH:mmZ")
                           (java.util.Date.))]
    (println timestamp "[INFO]" message)))

(defn process-events [events]
  (doseq [event events]
    (log (format "Event %s has been processed" (:id event)))))

;; redirecting output by `binding` `*out*` to a file
(let [file (java.io.File. (System/getProperty "java.io.tmpdir") "event-stream.log")]
  (with-open [file (io/writer file :append true)]
    (binding [*out* file]
      (process-events [{:id 88896} {:id 88898}]))))

