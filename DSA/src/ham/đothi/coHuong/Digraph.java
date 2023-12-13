package ham.đothi.coHuong;

import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private final int V;
    private List<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                System.out.println(v + "->" + w);
    }
}
