#_{:clj-kondo/ignore [:use]}
(use 'criterium.core)

(require 'hiphip.int)

(def array (into-array Integer/TYPE (range 100)))

(bench (hiphip.int/asum array))
