package ham.đothi.voHuong;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int V; // Number of vertices
    private Bag<Integer>[] adj; // Adjacency list

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt()); // Read V and initialize the graph
        int E = in.readInt(); // Read E (number of edges)
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public static void main(String[] args) {
        In in = new In("src\\ham\\cây\\temp.txt");
        Graph G = new Graph(in);
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
    }
}
