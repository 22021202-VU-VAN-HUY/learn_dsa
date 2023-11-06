package ham;

public class MaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    // create an empty priority queue
    public MaxPriorityQueue(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    // create an empty priority queue with given keys
    public MaxPriorityQueue(Key[] a) {
        this.pq = a;
    }

    // is the priority queue empty ?
    public boolean isEmpty() {
        return n == 0;
    }


    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    // insert a key into the priority queue
    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && (less(j, j + 1))) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    // return and remove the largest key
    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }


    // return largest key
    public Key max() {
        return pq[1];
    }

    // number of entries in the priority queue
    public int size() {
        return n;
    }

    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void exch(int i, int j) {
        Key x = pq[i];
        pq[i] = pq[j];
        pq[j] = x;
    }


}
