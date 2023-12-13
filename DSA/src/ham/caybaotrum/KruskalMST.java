package ham.caybaotrum;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class KruskalMST {
    private Queue<Edge> mst = new LinkedList<>(); // Use LinkedList as an implementation of Queue

    public KruskalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq = new MinPQ<>((Comparator) G.edges());

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(e); // Use add() instead of enqueue()
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
