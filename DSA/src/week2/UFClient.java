package week2;

import edu.princeton.cs.algs4.*;

public class UFClient {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q); StdOut.println(p + " " + q);
            }
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
