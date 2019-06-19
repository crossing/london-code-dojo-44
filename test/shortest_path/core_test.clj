(ns shortest-path.core-test
  (:require [clojure.test :refer :all]
            [shortest-path.core :as sut]))

(deftest shortest-path
  (testing "for the graph of one node"
    (let [graph {:a #{}}]
      (testing "should produce the only node"
        (is (= [:a]
               (sut/shortest-path graph :a :a))))))
  (testing "for the graph of two nodes"
    (let [graph {:a #{:b}}]
      (testing "should produce the only path"
        (is (= [:a :b]
               (sut/shortest-path graph :a :b)))
        (testing "should work backwards"
          (is (= [:b :a]
                 (sut/shortest-path graph :b :a))))))))

(deftest nodes
  (testing "for a graph of two nodes"
    (let [graph {:a #{:b}}]
      (testing "should return the all the nodes"
        (is (= [:a :b]
               (sut/nodes graph)))))))

(deftest neighbours
  (testing "for a graph of two nodes"
    (let [graph {:a #{:b}}]
      (testing "should return the neighbours"
        (is (= [:b]
               (sut/neighbours graph :a))))
      (testing "should find the implicit neighbours of b"
        (is (= [:a]
               (sut/neighbours graph :b))))))
  )

;; SPECS
;; shortest-path should take a graph
;; should produce a list of candidate paths

