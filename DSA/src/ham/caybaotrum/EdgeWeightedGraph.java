package ham.caybaotrum;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

    private final int V;
    private final List<Bag<Edge>> adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int v = 0; v < V; v++)
            adj.add(new Bag<>());
    }

    // add weighted edge e to this Graph
    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj.get(v).add(e);
        adj.get(w).add(e);
    }

    // edges incident to v
    public Iterable<Edge> adj(int v) {
        return adj.get(v);
    }

    // all edges in this graph
    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj.get(v)) {
                if (e.other(v) > v) {
                    edges.add(e);
                }
            }
        }
        return edges;
    }

    // number of vertices
    public int V() {
        return V;
    }

    // number of edges
    public int E() {
        int edgesCount = 0;
        for (int v = 0; v < V; v++) {
            edgesCount += adj.get(v).size();
        }
        return edgesCount / 2; // Each edge is counted twice
    }

    // String representation
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" vertices, ").append(E()).append(" edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (Edge e : adj.get(v)) {
                s.append(e).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
