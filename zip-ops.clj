(use '[clojure.string :only (join)])

(def ^:constant nums-2-10 (map str (range 2 10)))


(defn cart
  "Finds the Cartesian product of each collection in a collection of collections."
  [colls]
  (if (empty? colls)
    '(())
    (for [el (first colls)
          more (cart (rest colls))]
      (cons el more))))

(def cart-ops
  (cart (repeat 8 '("" "+" "-"))))

(def zipped-ops
  (map
   (fn [l]
     (flatten (cons "1" (map vector l nums-2-10))))
   cart-ops))

(spit "for-node.txt" (join "\n" (map join zipped-ops)))






