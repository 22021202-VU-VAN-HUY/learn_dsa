package week6;

import java.util.List;

// https://www.hackerrank.com/challenges/insertionsort1/problem
class InsertionSort_Part1 {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    public static void printlnList(List<Integer> arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        if (n >= 2) {
            int number = arr.get(n - 1);
            int i = n - 2;
            while (arr.get(i) > number) {
                arr.set(i + 1, arr.get(i));
                printlnList(arr, n);
                i--;
                if (i == -1) break;
            }
            arr.set(i + 1, number);
            printlnList(arr, n);
        } else printlnList(arr, n);
    }
}
