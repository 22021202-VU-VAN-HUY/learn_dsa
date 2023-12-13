package week11;

import org.w3c.dom.Node;

import java.util.*;

// https://www.hackerrank.com/challenges/find-the-running-median/problem
class FindTheRunningMedian{
    static class Node {
        int value;
        int order;

        public Node(int value, int order) {
            this.value = value;
            this.order = order;
        }
    }

    class Result {
        public static List<Double> runningMedian(List<Integer> a) {
            List<Double> medians = new ArrayList<>();
            TreeSet<Node> set = new TreeSet<>((n1, n2) -> {
                if (n1.value != n2.value) {
                    return Integer.compare(n1.value, n2.value);
                } else {
                    return Integer.compare(n1.order, n2.order);
                }
            });

            int order = 0;

            for (int i = 0; i < a.size(); i++) {
                int num = a.get(i);
                Node newNode = new Node(num, order++);
                set.add(newNode);

                Node higherNode = set.higher(newNode);
                Node lowerNode = set.lower(newNode);

                if (i % 2 == 0) {
                    medians.add((double) newNode.value);
                } else {
                    medians.add((lowerNode.value + higherNode.value) / 2.0);
                }
            }

            return medians;
        }
    }
}

