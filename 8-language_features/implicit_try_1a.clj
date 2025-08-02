(defmacro with-implicit-try [& defns]
  `(do
     ~@(map
        (fn [defn-expression]
          (let [initial-args (take 3 defn-expression)
                body (drop 3 defn-expression)]
            `(~@initial-args (try ~@body))))
        defns)))

(with-implicit-try
  (defn delete-file [path]
    (clojure.java.io/delete-file path)
    (catch java.io.IOException e false)))
