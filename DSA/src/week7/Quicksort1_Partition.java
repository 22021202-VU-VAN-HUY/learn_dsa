package week7;

import java.util.List;

// https://www.hackerrank.com/challenges/quicksort1/problem
class Quicksort1_Partition {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    private static int partition(List<Integer> arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int temp = arr.get(0);
        while (true) {
            while (arr.get(++i) < arr.get(lo)) {
                if (i == hi) break;
            }
            while (arr.get(lo) < arr.get(--j)) {
                if (j == lo) break;
            }
            if (i >= j) break;
            int k = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, k);
        }
        int k = arr.get(lo);
        arr.set(lo, arr.get(j));
        arr.set(j, k);
        return j;
    }

    private static void sort(List<Integer> a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        if (n >= 2) {
            sort(arr, 0, arr.size() - 1);
        }
        return arr;
    }
}
