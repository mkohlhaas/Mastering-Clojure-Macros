(match [1 2 3]
  [0 y z] :yx-plane
  [x 0 z] :xz-plane
  [x y 0] :xy-plane
  :other)

;=> nil

