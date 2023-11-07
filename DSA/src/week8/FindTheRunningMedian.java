package week8;

import edu.princeton.cs.algs4.In;

import java.util.*;


// FindTheRunningMedian

class FindTheRunningMedian {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> medians = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : a) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() == minHeap.size()) {
                medians.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                medians.add((double) maxHeap.peek());
            }
        }

        return medians;
    }
}
