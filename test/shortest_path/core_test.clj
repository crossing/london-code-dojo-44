(ns shortest-path.core-test
  (:require [clojure.test :refer :all]
            [shortest-path.core :as sut]))

(deftest shortest-path
  (testing "for the empty graph"
    (let [empty-graph []]
      (testing "should produce no paths"
        (is (= []
               (sut/shortest-path empty-graph)))))))

;; SPECS
;; shortest-path should take a graph
;; should produce a list of candidate paths
;; [:a #{}]
;; []
