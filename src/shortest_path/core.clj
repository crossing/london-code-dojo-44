(ns shortest-path.core)

#_(defn nodes [graph]
  (set (flatten (map (fn [x] (if (set? x) (vec x))) graph))))

(defn nodes [graph]
  (dedupe (concat (keys graph)
                  (apply concat (vals graph)))))

(defn neighbours [graph node]
  (let [first-case (graph node)
        second-case (map key (filter (fn [[k v]] (v node)) graph))]
    (concat first-case second-case)))

(defn shortest-path [graph start end]
  (let [ns (neighbours graph start)]
    (if ((set ns) end)
      [start end]
      [start])))
