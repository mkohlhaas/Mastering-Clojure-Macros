#_{:clj-kondo/ignore [:redefined-var]}
;; `dosync` is the entry point to Clojure’s software transactional memory(STM) system
(defmacro dosync
  "Runs the exprs (in an implicit do) in a transaction that encompasses
  exprs and any nested calls.  Starts a transaction if none is already
  running on this thread. Any uncaught exception will abort the
  transaction and flow out of dosync. The exprs may be run more than
  once, but any effects on Refs will be atomic."
  {:added "1.0"}
  [& exprs]
  `(sync nil ~@exprs))

#_{:clj-kondo/ignore [:redefined-var]}
(defmacro sync
  "transaction-flags => TBD, pass nil for now

  Runs the exprs (in an implicit do) in a transaction that encompasses
  exprs and any nested calls.  Starts a transaction if none is already
  running on this thread. Any uncaught exception will abort the
  transaction and flow out of sync. The exprs may be run more than
  once, but any effects on Refs will be atomic."
  {:added "1.0"}
  [_flags-ignored-for-now & body]
  `(. clojure.lang.LockingTransaction
      (runInTransaction (fn [] ~@body))))

(def ant-1 (ref {:id 1 :x 0 :y 0}))
(def ant-2 (ref {:id 2 :x 10 :y 10}))

(dosync
 (alter ant-1 update-in [:x] inc)
 (alter ant-1 update-in [:y] inc)
 (alter ant-2 update-in [:x] dec)
 (alter ant-2 update-in [:y] dec))

@ant-1 ; {:id 1, :x 1, :y 1}
@ant-2 ; {:id 2, :x 9, :y 9}
