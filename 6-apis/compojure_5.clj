(defn- compile-route
  "Compile a route in the form (method path & body) into a function."
  [method route bindings body]
  `(make-route
    ~method ~(prepare-route route)
    (fn [request#]
      (let-request [~bindings request#] ~@body))))

(defmacro GET "Generate a GET route."
  [path args & body]
  (compile-route :get path args body))

