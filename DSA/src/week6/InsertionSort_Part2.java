package week6;

import java.util.List;

// https://www.hackerrank.com/challenges/insertionsort2/problem
class InsertionSort_Part2 {
    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exch(List a, int i, int j) {
        int x = (int) a.get(i);
        a.set(i, a.get(j));
        a.set(j, x);
    }
    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int m, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        if (n >= 2) {
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0; j--) {
                    if (less(arr.get(j), arr.get(j - 1))) {
                        exch(arr, j, j - 1);
                    }
                    ;
                }
                for (int j = 0; j < n; j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.println("");
            }
        } else System.out.println(arr.get(0));
    }
}