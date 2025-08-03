(require '[clojure.string :as str])

#_{:clj-kondo/ignore [:redefined-var]}
;; like `with-out-str` but for input
(defmacro with-in-str
  "Evaluates body in a context in which *in* is bound to a fresh
  StringReader initialized with the string s."
  {:added "1.0"}
  [s & body]
  `(with-open [s# (-> (java.io.StringReader. ~s)
                      clojure.lang.LineNumberingPushbackReader.)]
     (binding [*in* s#]
       ~@body)))

;; reads from `*in*`, replaces newlines with commas and prints result to `*out*`
(defn join-input-lines [_separator]
  (print (str/replace (slurp *in*) "\n" ",")))

;; reads from string and writes to a string
(with-in-str "hello there\nhi\nsup\nohai"
  (with-out-str
    (join-input-lines ",")))
; "hello there,hi,sup,ohai"

(let [result (with-in-str "hello there\nhi\nsup\nohai"
               (with-out-str
                 (join-input-lines ",")))]
  (assert (= "hello there,hi,sup,ohai" result)))
