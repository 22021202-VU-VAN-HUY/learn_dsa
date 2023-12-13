package ham.week1_11;

import edu.princeton.cs.algs4.StdRandom;

public class Shuffling {
    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(n + 1);
            exch(a, i, r);
        }
    }

    private static void exch(Object[] a, int i, int j) {
        Object x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
}
