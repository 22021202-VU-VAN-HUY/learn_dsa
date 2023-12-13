package ham.đothi.voHuong;

import java.util.LinkedList;
import java.util.Queue;

// duyệt theo chiều rộng
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<>(); // Sử dụng LinkedList làm hàng đợi
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll(); // Sử dụng poll() thay vì dequeue()
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}