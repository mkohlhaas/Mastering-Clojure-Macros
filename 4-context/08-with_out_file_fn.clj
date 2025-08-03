;; ;;;;;;;;;;;;;;;;;;;;
;; A Non-Macro Approach
;; ;;;;;;;;;;;;;;;;;;;;

;; only functions
;; (fn [] ...) wrapping

(require '[clojure.java.io :as io])

;; `body-fn` is a function without any parameters
(defn with-out-file [file body-fn]
  (with-open [writer (io/writer file :append true)]
    (binding [*out* writer]
      (body-fn))))

(defn log [message]
  (let [timestamp (.format (java.text.SimpleDateFormat. "yyyy-MM-dd'T'HH:mmZ")
                           (java.util.Date.))]
    (println timestamp "[INFO]" message)))

(defn process-events [events]
  (doseq [event events]
    ;; do some meaningful work based on the event
    (log (format "Event %s has been processed" (:id event)))))

(let [file (java.io.File. (System/getProperty "java.io.tmpdir") "event-stream.log")]
  (with-out-file file
    (fn []  ; (fn [] ...) wrapping
      (process-events [{:id 88894} {:id 88895} {:id 88897}])
      (process-events [{:id 88896} {:id 88898}]))))
