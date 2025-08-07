;; lein try [org.clojure/tools.macro "0.1.5"]
(require '[clojure.tools.macro :as m])

(defn- default-docstring [name]
  (str "The author carelessly forgot to provide a docstring for `"
       name
       "`. Sorry!"))

(defmacro my-defn [name & body]
  (let [[name args] (m/name-with-attributes name body)
        name (if (:doc (meta name))
               name
               (vary-meta name assoc :doc (default-docstring name)))]
    `(defn ~name ~@args)))

(my-defn foo [])
;=> #'user/foo
(doc foo)
; -------------------------
; user/foo
; ([])
;   The author carelessly forgot to provide a docstring for `foo`. Sorry!
;=> nil
