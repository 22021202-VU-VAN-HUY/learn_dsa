package Vebo;

import java.util.List;

public class JesseAndCookies {
    class Result {

        /*
         * Complete the 'cookies' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY A
         */

        public static int cookies(int k, List<Integer> A) {
            // Write your code here
            if (A.size()>=2){
                int dem=1;
                int number1 = A.remove(0);
                int number2 = A.remove(0);
            }
            return 0;
        }
    }

        public static void sort(Comparable[] a) {
            int n = a.length;
            for (int k = n / 2; k >= 1; k--) {
                sink(a, k, n);
            }
            while (n > 1) {
                exch(a, 1, n);
                sink(a, 1, --n);
            }
        }

        private static void sink(Comparable[] a, int k, int n) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && (less(a, j, j + 1))) j++;
                if (!less(a, k, j)) break;
                exch(a, k, j);
                k = j;
            }
        }

        private static boolean less(Comparable[] a, int i, int j) {
            return a[i].compareTo(a[j]) < 0;
        }

        private static void exch(Comparable[] a, int i, int j) {
            Comparable x = a[i];
            a[i] = a[j];
            a[j] = x;
        }

}
