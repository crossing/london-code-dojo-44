(ns shortest-path.core)

#_(defn nodes [graph]
  (set (flatten (map (fn [x] (if (set? x) (vec x))) graph))))

(defn nodes [graph]
  (let [[n neighbours] (first graph)]
    (concat [n] neighbours)))

(defn neighbours [graph node]
  (let [[n [neighbour & _]] (first graph)]
    (if (= n node)
      [neighbour]
      [n])))

(defn shortest-path [graph start end]
  (let [ns (neighbours graph start)]
    (if ((set ns) end)
      [start end]
      [start])))
