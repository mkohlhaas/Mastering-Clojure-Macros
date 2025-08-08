(ns features.pattern-matching.pattern-matching-4-spec
  (:require [speclj.core :refer [describe it should=]]
            [features.pattern-matching.pattern-matching-4 :refer [mmerge]]))

(describe
 "matching merge"
 (it "implements merge (from merge-sort)"
     (should= [1 2 3] (mmerge [1 2 3] []))
     (should= [1 2 3] (mmerge [1 2 3] nil))
     (should= [1 2 3 4] (mmerge [1 2 3] [4]))
     (should= [1 2 3] (mmerge [] [1 2 3]))
     (should= [1 2 3] (mmerge nil [1 2 3]))
     (should= [1 2 3 4 5 6 7] (mmerge [1 3 4 7] [2 5 6]))))
