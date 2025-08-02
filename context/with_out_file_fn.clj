(defn with-out-file [file body-fn]
  (with-open [writer (clojure.java.io/writer file :append true)]
    (binding [*out* writer]
      (body-fn))))

(let [file (java.io.File. (System/getProperty "user.home") "event-stream.log")]
  (with-out-file file
    (fn []
      (process-events [{:id 88894} {:id 88895} {:id 88897}])
      (process-events [{:id 88896} {:id 88898}]))))
