(ns shortest-path.core-test
  (:require [clojure.test :refer :all]
            [shortest-path.core :as sut]))

(deftest shortest-path
  (testing "for the graph of one node"
    (let [graph [:a #{}]]
      (testing "should produce no paths"
        (is (= []
               (sut/shortest-path graph :a :a)))))))

;; SPECS
;; shortest-path should take a graph
;; should produce a list of candidate paths
;; [:a #{}]
;; []
