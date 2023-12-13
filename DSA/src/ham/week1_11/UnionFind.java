package ham.week1_11;

import java.util.Scanner;

public class UnionFind {
    private int[] id;

    private int root(int i){
        while (i!=id[i]){
            id[i]=id[id[i]];
            i=id[i];
        }
        return i;
    }
    
    public UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int a, int b) {
        int i = find(a);
        int j = find(b);
        id[i]=j;
    }

    public int find(int i) {
        while (i!=id[i]) i = id[i];
        return i;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        UnionFind uf = new UnionFind(n);
        boolean next = true;
        while (next) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a < 0 || b < 0) {
                next = false;
                break;
            } else if (!uf.connected(a, b)) {
                uf.union(a, b);
                System.out.println(a + " " + b);
            }
        }
    }
    /*

    10
    4 3
    3 8
    6 5
    9 4
    2 1
    8 9
    5 0
    7 2
    6 1
    1 0
    6 7

     */
}


