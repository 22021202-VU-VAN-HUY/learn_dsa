package ham.caybaotrum;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class MST {
    private Queue<Edge> mst;
    private double weight;

    public MST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        weight = 0.0;

        // Add your MST algorithm implementation here
        // You can use Prim's or Kruskal's algorithm
    }

    // Return edges in MST
    public Iterable<Edge> edges() {
        return mst;
    }

    // Return weight of MST
    public double weight() {
        return weight;
    }

    // Implement your MST algorithm here, either Prim's or Kruskal's
    // Add private methods or classes as needed
}
