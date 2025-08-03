(require '[clojure.java.io :as io])

;; `log` and `process` from previous files
(defn log [message]
  (let [timestamp (.format (java.text.SimpleDateFormat. "yyyy-MM-dd'T'HH:mmZ")
                           (java.util.Date.))]
    (println timestamp "[INFO]" message)))

(defn process-events [events]
  (doseq [event events]
    ;; do some meaningful work based on the event
    (log (format "Event %s has been processed" (:id event)))))

;; function version
(defn with-out-file-fn [file body-fn]
  (with-open [writer (io/writer file :append true)]
    (binding [*out* writer]
      (body-fn))))

;; macro as a thin wrapper around the function version to spare the `(fn[]...)` stuff
(defmacro with-out-file [file & body]
  `(with-out-file-fn ~file
     (fn [] ~@body)))

;; using the macro
(let [file (java.io.File. (System/getProperty "java.io.tmpdir") "event-stream.log")]
  (with-out-file file
    (process-events [{:id 88894} {:id 88895} {:id 88897}])
    (process-events [{:id 88896} {:id 88898}])))

;; Users have the choice to use the more concise macro version or
;; the more flexible function version!
