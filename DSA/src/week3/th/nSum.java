package week3.th;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;  // sử dụng các phương thức liên quan tới mảng
import java.util.List;
//package edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.*;

public class nSum {
    // Do not instantiate.
    private nSum() {
    }
    
    public static List<Integer> arr(int[] array) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);

        for (int i = 0; i < array.length; i++) {
            int n = arr.size();
            //arr.add(array[i]);
            for (int j = 0; j < n; j++) {
                arr.add(array[i] + arr.get(j));
            }
        }
        return arr;
    }

    /**
     * public static void main(String[] args) {
     * String path = "C:\\Users\\FPTSHOP\\Desktop\\learn_java\\DSA\\src\\week3\\text_test\\4Kints.txt";
     * In in = new In(path);
     * int[] a = in.readAllInts();
     * Arrays.sort(a);
     * Stopwatch timer = new Stopwatch();
     * int count = count(a);
     * StdOut.println("elapsed time = " + timer.elapsedTime());
     * StdOut.println("all: " + count);
     * }
     */
    public static void main(String[] args) {
        int[] a = new int[]{1, -1, 2, 0};
        List<Integer> result = arr(a);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
