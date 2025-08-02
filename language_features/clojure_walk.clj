(require '[clojure.walk :as cw])
(cw/macroexpand-all '(let [when :now] (when {:now "Go!"})))
;=> (let* [when :now] (if {:now "Go!"} (do)))

;; lein try org.clojars.trptcolin/riddley "0.1.7.1"

(require '[riddley.walk :as rw])
(rw/macroexpand-all '(let [when :now] (when {:now "Go!"})))
;=> (let* [when :now] (when {:now "Go!"}))
