;; ;;;;;;;;;;;;;;;;;;;;;;;;
;; Evaluate Code in Context
;; ;;;;;;;;;;;;;;;;;;;;;;;;

(require '[clojure.java.io :as io])

;; structurally the same code

(defn info-to-file [path text]
  (let [file (io/writer path :append true)]
    (try
      (binding [*out* file]
        (println "[INFO]" text)) ; only difference
      (finally
        (.close file)))))

(defn error-to-file [path text]
  (let [file (io/writer path :append true)]
    (try
      (binding [*out* file]
        (println "[ERROR]" text)) ; only difference
      (finally
        (.close file)))))
