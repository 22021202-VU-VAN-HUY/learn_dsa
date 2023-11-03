package week7;

import java.util.*;

// https://www.hackerrank.com/challenges/quicksort3/problem
public class QuicksortIn_Place {
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    private static int partition(int[] a, int lo, int hi) {
        int temp = a[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] < temp) {
                change(a, i, j);
                i++;
            }
        }
        change(a, i, hi);
        return i;
    }

    public static void change(int[] a, int x, int y) {
        int k = a[x];
        a[x] = a[y];
        a[y] = k;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        printArr(a);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr, 0, arr.length - 1);
    }
}

//      7  1 3 9 8 2 7 5
//        1 3 2 5 9 7 8
//        1 2 3 5 9 7 8
//        1 2 3 5 7 8 9