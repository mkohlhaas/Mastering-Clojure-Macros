(defn with-out-file-fn [file body-fn]
  (with-open [writer (clojure.java.io/writer file :append true)]
    (binding [*out* writer]
      (body-fn))))

(defmacro with-out-file [file & body]
  `(with-out-file-fn ~file
     (fn [] ~@body)))

(let [file (java.io.File. (System/getProperty "user.home") "event-stream.log")]
  (with-out-file file
    (process-events [{:id 88894} {:id 88895} {:id 88897}])
    (process-events [{:id 88896} {:id 88898}])))
