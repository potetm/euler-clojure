(ns euler-clojure.core-test
  (:require [clojure.test :refer :all]
            [euler-clojure.core :as e]))

(deftest problem-1
  (testing "the sum of all the multiples of 3 or 5 below 1000"
    (is (= 233168 (e/problem-1 1000)))))

(deftest problem-2
  (testing "considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms"
    (is (= 4613732 (e/problem-2 4000000)))))

(deftest problem-3
  (testing "the largest prime factor of the number 600851475143"
    (is (= 6857 (e/problem-3 600851475143)))))

(deftest problem-4
  (testing "the largest palindrome made from the product of two 3-digit numbers"
    (is (= [993 913 906609] (e/problem-4)))))

(deftest problem-5
  (testing "the smallest positive number that is evenly divisible by all of the numbers from 1 to 20"
    (is (= 232792560 (e/problem-5)))))
