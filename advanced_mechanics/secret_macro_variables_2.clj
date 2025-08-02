(defmacro inspect-caller-locals []
  (->> (keys &env)
       (map (fn [k] [`'~k k]))
       (into {})))

user=> (inspect-caller-locals)
{}
user=> (let [foo "bar" baz "quux"] (inspect-caller-locals))
{baz "quux", foo "bar"}
