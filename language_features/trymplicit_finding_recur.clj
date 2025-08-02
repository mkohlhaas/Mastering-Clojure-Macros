(def recur-found (atom false))

(defn should-transform? [x]
  (and (seq? x)
       ;; NOTE: we've added 'recur - easy to forget
       (#{'recur 'fn* 'do 'loop* 'let* 'letfn* 'reify*} (first x))))

(defn transform [x]
  (condp = (first x)
    'recur (let [[verb & args] x]
             (reset! recur-found true)
             x)
    ;; ...
    'fn* (let [[verb & fn-decl] x
               _ (reset! recur-found false)
               result `(fn* ~@(doall (wrap-fn-decl fn-decl)))]
           (if @recur-found
             x
             result))))
    ;; ...
    ;; ...
