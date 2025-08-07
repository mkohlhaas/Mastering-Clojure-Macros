(let [counter (atom 0)]
  (symbol-macrolet [bump! (swap! counter inc)]
                   bump!
                   bump!
                   bump!
                   @counter))
;=> 3
