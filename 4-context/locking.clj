(defmacro locking
  "Executes exprs in an implicit do, while holding the monitor of x.
  Will release the monitor of x in all circumstances."
  {:added "1.0"}
  [x & body]
  `(let [lockee# ~x]
     (try
       (monitor-enter lockee#)
       ~@body
       (finally
         (monitor-exit lockee#)))))

(def mutex (Object.))
(locking mutex
  (perform-dangerous-mutating-operation-1)
  (perform-dangerous-mutating-operation-2))
