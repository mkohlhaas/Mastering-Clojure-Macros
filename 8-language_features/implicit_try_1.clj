(defn delete-file [path]
  (clojure.java.io/delete-file path)
  (catch java.io.IOException e false))
