package week5;

import edu.princeton.cs.algs4.StdOut;

public class SelectionSort {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                    exch(a, i, min);
                }
            }
        }
    }

    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exch(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 9, 8};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        long start = System.currentTimeMillis();
        //run something that takes time
        long end = System.currentTimeMillis();
        System.out.println("Thời gian chạy:" + (end - start))

        ;
    }
}
