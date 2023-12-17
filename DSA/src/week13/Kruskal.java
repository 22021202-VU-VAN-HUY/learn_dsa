package week13;
import java.util.*;
// https://www.hackerrank.com/challenges/kruskalmstrsub/problem
class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        if (p == parent[p]) return p;
        return parent[p] = find(parent[p]);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int pp = find(p);
        int pq = find(q);
        if (pp != pq) {
            if (size[pp] > size[pq]) {
                int tmp = pp;
                pp = pq;
                pq = tmp;
            }
            parent[pq] = pp;
            size[pp] += size[pq];
        }
    }
}

class Edge implements Comparable<Edge> {
    public int u, v, w;

    public Edge(int u, int v, int distance) {
        if (u>v){
            this.u=v;
            this.v=u;
        }else{
            this.u = u;
            this.v = v;
        }
        this.w = distance;
    }

    @Override
    public int compareTo(Edge temp) {
        if (w < temp.w) return -1;
        if (w > temp.w) return 1;
        if (u < temp.u) return -1;
        if (u > temp.u) return 1;
        return Integer.compare(v, temp.v);
    }
}



public class Kruskal {
    private static int kruskals(int n, Queue<Edge> pq) {
        int dmin = 0;
        UnionFind uf = new UnionFind(n);
        for (int i = 1; i < n; i++) {
            Edge min = pq.poll();
            while (!pq.isEmpty() && uf.isConnected(min.u, min.v)) {
                min = pq.poll();
            }
            uf.union(min.u, min.v);
            dmin += min.w;
        }

        return dmin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Edge edge = new Edge(u, v, w);
            pq.add(edge);
        }
        System.out.println(kruskals(n, pq));
    }
}