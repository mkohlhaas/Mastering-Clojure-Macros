(import 'java.io.FileInputStream)

(defn read-file [file-path]
  (let [buffer (byte-array 4096)
        contents (StringBuilder.)]
    (with-open [file-stream (FileInputStream. file-path)]
      (while (not= -1 (.read file-stream buffer))
        (.append contents (String. buffer))))
    (str contents)))
