(ns shortest-path.core-test
  (:require [clojure.test :refer :all]
            [shortest-path.core :as sut]))

(deftest shortest-path
  (testing "for the graph of one node"
    (let [graph [:a #{}]]
      (testing "should produce no paths"
        (is (= []
               (sut/shortest-path graph :a :a))))))
  (testing "for the graph of two nodes"
    (let [graph [:a #{:b}]]
      (testing "should produce the only path"
        (is (= [:a :b]
               (sut/shortest-path graph :a :b)))))))

;; SPECS
;; shortest-path should take a graph
;; should produce a list of candidate paths

