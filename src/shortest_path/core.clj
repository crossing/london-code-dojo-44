(ns shortest-path.core)

(defn shortest-path [graph start end]
  (let [[n neighbours] graph]
    (if (seq neighbours)
      [start end]
      [])))
