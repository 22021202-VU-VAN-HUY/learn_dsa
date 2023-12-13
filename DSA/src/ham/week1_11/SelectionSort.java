package ham.week1_11;

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
}
