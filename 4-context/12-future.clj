#_{:clj-kondo/ignore [:redefined-var]}
(defmacro future
  "Takes a body of expressions and yields a future object that will
  invoke the body in another thread, and will cache the result and
  return it on all subsequent calls to deref/@. If the computation has
  not yet finished, calls to deref/@ will block, unless the variant of
  deref with timeout is used. See also - realized?."
  {:added "1.1"}
  [& body] `(future-call (^{:once true} fn* [] ~@body)))

(def f (future (Thread/sleep 2000)
               (println "done!")
               (+ 41 1)))

@f ; 42 (after sleeping 2 seconds and then printing "done!")
