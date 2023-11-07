package Vebo;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/contests/vebo/challenges/ve-bo-2-gift/problem
public class Vebo2_Gift {
    public static void show(List<Long> result) {
        for (Long temp : result) {
            System.out.print(temp + " ");
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // PriorityQueue<Long> list = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> list = new PriorityQueue<>();
        List<Long> result = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[] a = new Long[n];
        int k = sc.nextInt();
        long max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            if (list.size() < k) {
                max += a[i];
                list.add(a[i]);
                result.add(max);
            } else {
                if (a[i] > list.peek()) {
                    max = max - list.poll() + a[i];
                    list.add(a[i]);
                    result.add(max);
                } else {
                    result.add(max);
                }
            }
        }

        show(result);
    }
}