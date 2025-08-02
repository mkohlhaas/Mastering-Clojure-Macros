(macrolet [(do-twice [form] `(do ~form ~form))]
          (do-twice (println "hi")))
; hi
; hi
;=> nil
