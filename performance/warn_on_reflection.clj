user=> (set! *warn-on-reflection* true)
;=> true
user=> (defn length-1 [x] (.length x))
;Reflection warning, NO_SOURCE_PATH:1:20 -
;   reference to field length can't be resolved.
;#'user/length-1
