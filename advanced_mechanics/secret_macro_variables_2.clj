(defmacro inspect-caller-locals []
  (->> (keys &env)
       (map (fn [k] [`'~k k]))
       (into {})))

(inspect-caller-locals)
{}
(let [foo "bar" baz "quux"] (inspect-caller-locals))
{baz "quux", foo "bar"}
