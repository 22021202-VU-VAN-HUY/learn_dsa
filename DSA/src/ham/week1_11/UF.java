package ham.week1_11;

public class UF {
    private int[] id;
    private int[] size;

    public UF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            if (size[a] >= size[b]) {
                id[rootb] = roota;
                size[roota] += size[rootb];
            } else {
                id[roota] = rootb;
                size[rootb] += size[roota];
            }
        }
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    public int length(int i) {
        return size[find(i)];
    }
}
