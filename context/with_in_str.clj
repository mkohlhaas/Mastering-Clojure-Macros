(defmacro with-in-str
  "Evaluates body in a context in which *in* is bound to a fresh
  StringReader initialized with the string s."
  {:added "1.0"}
  [s & body]
  `(with-open [s# (-> (java.io.StringReader. ~s)
                      clojure.lang.LineNumberingPushbackReader.)]
     (binding [*in* s#]
       ~@body)))

(defn join-input-lines [separator]
  (print (clojure.string/replace (slurp *in*) "\n" ",")))

(let [result (with-in-str "hello there\nhi\nsup\nohai"
               (with-out-str
                 (join-input-lines ",")))]
  (assert (= "hello there,hi,sup,ohai" result)))
