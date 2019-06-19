(ns shortest-path.core)

(defn get-nodes [graph]
  (dedupe (concat (keys graph)
                  (apply concat (vals graph)))))

(defn get-neighbours [graph node]
  (let [->node key
        implied-node? (fn [[_ neighbours]] (neighbours node))
        implicit-nodes (->> graph
                            (filter implied-node?)
                            (map ->node))
        explicit-nodes (graph node)]
    (into #{} (concat explicit-nodes implicit-nodes))))

(defn tried-all-nodes? [path neighbours]
  (= (set path) neighbours))

(defn shortest-path [graph start end]
  (loop [path []
         start start]
    (let [neighbours (get-neighbours graph start)]
      (cond (neighbours end)
            (conj path start end)

            (tried-all-nodes? path neighbours) ;; reached the end
            (conj path start)

            :else
            (recur (conj path start)
                   (first neighbours))))))
