package Vebo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/contests/vebo/challenges/ve-bo-1-who-is-in-the-middle/problem
public class Vebo1_WhoIsInTheMiddle {
    public static void balance(PriorityQueue<Long> max, PriorityQueue<Long> min) {
        // min+1==max or min=max
        if (max.size() < min.size()) {
            max.add(min.poll());
        } else if (max.size() > min.size() + 1) {
            min.add(max.poll());
        }

    }

    public static void add(PriorityQueue<Long> max, PriorityQueue<Long> min, long k) {
        if (max.isEmpty() || k <= max.peek()) {
            max.add(k);
        } else min.add(k);
        balance(max, min);
    }

    public static void middle(PriorityQueue<Long> max, PriorityQueue<Long> min) {

        if (max.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(max.peek());
        }
    }

    public static void remove(PriorityQueue<Long> max, PriorityQueue<Long> min) {
        max.poll();
        balance(max, min);
    }

    public static void main(String[] args) {
        PriorityQueue<Long> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minPQ = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long step = sc.nextLong();
        for (long i = 0; i < n; i++) {
            add(maxPQ, minPQ, sc.nextLong());
        }
        for (long i = 0; i < step; i++) {
            long choose = sc.nextLong();
            if (choose == 1) {
                long k = sc.nextLong();
                add(maxPQ, minPQ, k);
            } else if (choose == 2) {
                remove(maxPQ, minPQ);
            } else if (choose == 3) {
                middle(maxPQ, minPQ);
            }
        }
    }
}
