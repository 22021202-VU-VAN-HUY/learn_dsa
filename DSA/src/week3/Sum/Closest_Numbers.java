package week3.Sum;

import edu.princeton.cs.algs4.*;

import java.util.*;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/closest-numbers/problem

public class Closest_Numbers {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        System.out.println("hello");
        int n = arr.size();
        Collections.sort(arr);

        int d_min = arr.get(1) - arr.get(0);
        for (int i = 0; i < n - 1; i++) {
            int d = arr.get(i + 1) - arr.get(i);
            if (d < d_min) d_min = d;
        }
        System.out.println(d_min);
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; i++) {
            int d = arr.get(i + 1) - arr.get(i);
            if (d == d_min) {
                answer.add(arr.get(i));
                answer.add(arr.get(i + 1));
            }
        }
        return answer;
    }
}