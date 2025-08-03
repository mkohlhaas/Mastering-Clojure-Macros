### Code for the book [Mastering Clojure Macros](https://pragprog.com/titles/cjclojure/mastering-clojure-macros/)

<img src="https://pragprog.com/titles/cjclojure/mastering-clojure-macros/cjclojure.jpg" width="30%" height="30%"/>

[Unifying Gensyms](https://github.com/clj-commons/potemkin?tab=readme-ov-file#unify-gensyms)

### The `'~k Riddle

- 2-advanced_mechanics/24-secret_macro_variables_2.clj
- 2-advanced_mechanics/25-secret_macro_variables_3.clj
  - \`'~k is equal to`(quote ~k)`and`(list 'quote k)`
  - `(list 'quote k)` going to syntax quoting: remove list, remove ', eval k

### delimc

- Nice project to study
  - [delimc](https://github.com/swannodette/delimc)
