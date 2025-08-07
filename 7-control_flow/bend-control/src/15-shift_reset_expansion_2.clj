#_{:clj-kondo/ignore [:refer-all]}
(require '[delimc.core :refer :all])

(macroexpand '(reset (+ 1 (shift k (k 1)))))
;; ((clojure.core/fn
;;   [G__2719 & rest-args__2566__auto__]
;;   ((clojure.core/fn
;;     [G__2720 & rest-args__2566__auto__]
;;     ((clojure.core/fn [k] (k 1))
;;      (clojure.core/fn
;;       [G__2721 & rest-args__2566__auto__]
;;       (funcall-cc
;;        G__2719
;;        #object[clojure.core$identity 0x3c09f4b2 "clojure.core$identity@3c09f4b2"]
;;        G__2720
;;        G__2721))))
;;    1))
;;  (function +))

#_{:clj-kondo/ignore [:unresolved-symbol]}
(reset (+ 1 (shift k (k 1))))
; 2
