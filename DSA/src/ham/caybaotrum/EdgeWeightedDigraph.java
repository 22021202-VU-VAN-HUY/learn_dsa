package ham.caybaotrum;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Edge;

public class EdgeWeightedDigraph {

    private final int V;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }

    // add weighted edge e to this Graph
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    // edges incident to v
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    // all edges in this graph
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> edges = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                edges.add(e);
            }
        }
        return edges;
    }
}
