(ns shortest-path.core)

(defn nodes [graph]
  (dedupe (concat (keys graph)
                  (apply concat (vals graph)))))

(defn neighbours [graph node]
  (let [->node key
        implied-node? (fn [[_ neighbours]] (neighbours node))
        implicit-nodes (->> graph
                            (filter implied-node?)
                            (map ->node))
        explicit-nodes (graph node)]
    (into #{} (concat explicit-nodes implicit-nodes))))

(defn shortest-path [graph start end]
  (loop [path []
         start start]
    (let [nodes (neighbours graph start)]
      (cond (nodes end)
            (conj path start end)

            (= (set path)
               nodes) ;; reached the end
            (conj path start)

            :else
            (recur (conj path start)
                   (first nodes))))))
