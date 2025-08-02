(source special-symbol?)
; (defn special-symbol?
;   "Returns true if s names a special form"
;   {:added "1.0"
;    :static true}
;   [s]
;     (contains? (. clojure.lang.Compiler specials) s))

(sort (keys clojure.lang.Compiler/specials))
;=> (& . case* catch def deftype* do finally fn* if let* letfn* loop*
;     monitor-enter monitor-exit new quote recur reify* set! throw try var
;     clojure.core/import*)
