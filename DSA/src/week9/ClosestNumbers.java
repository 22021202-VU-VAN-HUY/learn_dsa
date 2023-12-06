package week9;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

// https://www.hackerrank.com/challenges/closest-numbers/problem
public class ClosestNumbers {


    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void merge(List<Integer> a, List<Integer> temp, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp.set(i, a.get(i));
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a.set(k, temp.get(j++));
            else if (j > hi) a.set(k, temp.get(i++));
            else if (temp.get(i) > temp.get(j)) a.set(k, temp.get(j++));
            else a.set(k, temp.get(i++));
        }
    }

    public static void sort(List<Integer> a, List<Integer> temp, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, temp, lo, mid);
        sort(a, temp, mid + 1, hi);
        merge(a, temp, lo, mid, hi);
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        int n = arr.size();
        List<Integer> temp = new ArrayList<>(arr);
        sort(arr, temp, 0, arr.size() - 1);
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

    ////

    public static void show(List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        List<Integer> result = closestNumbers(arr);
        show(result);


    }
}
/*
    4
    5 4 3 2
 */