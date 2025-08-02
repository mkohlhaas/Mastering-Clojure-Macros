(defmacro inspect-caller-locals-1 []
  (->> (keys &env)
       (map (fn [k] [`(quote ~k) k]))
       (into {})))

(defmacro inspect-caller-locals-2 []
  (->> (keys &env)
       (map (fn [k] [(list 'quote k) k]))
       (into {})))

user=> (inspect-caller-locals-1)
{}
user=> (inspect-caller-locals-2)
{}
user=> (let [foo "bar" baz "quux"] (inspect-caller-locals-1))
{baz "quux", foo "bar"}
user=> (let [foo "bar" baz "quux"] (inspect-caller-locals-2))
{baz "quux", foo "bar"}
