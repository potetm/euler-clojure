(ns euler-clojure.core)

(defn- find-multiples [m n]
  (filter #(= 0 (mod % m))
          (range 1 n)))

(defn problem-1 [n]
  (reduce + (set
              (concat
                (find-multiples 3 n)
                (find-multiples 5 n)))))

(defn- gen-fib
  ([]
   (gen-fib 1 2))
  ([a b]
   (cons a (lazy-seq (gen-fib b (+ b a))))))

(defn problem-2 [n]
  (reduce + (filter even? (take-while (partial > n) (gen-fib)))))

;; from http://www.mathblog.dk/project-euler-problem-3/
(defn problem-3 [x]
  (loop [counter 2
         new-num x
         largest-fact 0]
    (if (<= (* counter counter) new-num)
      (if (= 0 (mod new-num counter))
        (recur
          counter
          (/ new-num counter)
          counter)
        (recur
          (inc counter)
          new-num
          largest-fact))
      (if (> new-num largest-fact)
        new-num
        largest-fact))))

(defn- palindrome? [x]
  (let [s (str x)
        [b e] (split-at (int (/ (count s) 2)) s)]
    (every? true? (map = b (reverse e)))))

(defn problem-4 []
  (first
    (filter
      (complement nil?)
      (mapcat
        identity
        (for [i (range 999 900 -1)]
          (for [j (range i 900 -1)]
            (when (palindrome? (* i j))
              [i j (* i j)])))))))

(defn- twenties
  ([]
   (twenties 20))
  ([x]
   (cons x (lazy-seq (twenties (+ 20 x))))))

(defn problem-5 []
  (first
    (filter
      (fn [i]
        (every? #(= 0 (mod i %))
                (range 20 1 -1)))
      (twenties))))
