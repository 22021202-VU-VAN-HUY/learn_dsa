package week13;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
// https://www.hackerrank.com/challenges/dijkstrashortreach/problem
class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    static class Distance implements Comparable<Distance> {
        public int d, v;

        public Distance(int d, int v) {
            this.d = d;
            this.v = v;
        }

        @Override
        public int compareTo(Distance other) {
            return Integer.compare(this.d, other.d);
        }
    }

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int start) {
        List<Distance>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph[u].add(new Distance(w, v));
            graph[v].add(new Distance(w, u));
        }

        PriorityQueue<Distance> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Distance(0, start));

        boolean[] visited = new boolean[n + 1];
        int[] ds = new int[n + 1];
        Arrays.fill(ds, Integer.MAX_VALUE);

        while (!priorityQueue.isEmpty()) {
            Distance current = priorityQueue.poll();
            int currentv = current.v;
            if (visited[currentv]) {
                continue;
            }

            visited[currentv] = true;
            ds[currentv] = current.d;

            for (Distance neighbor : graph[currentv]) {
                int nextv = neighbor.v;
                int edgeWeight = neighbor.d;

                if (!visited[nextv] && ds[nextv] > ds[currentv] + edgeWeight) {
                    ds[nextv] = ds[currentv] + edgeWeight;
                    priorityQueue.add(new Distance(ds[nextv], nextv));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != start) {
                result.add(ds[i] == Integer.MAX_VALUE ? -1 : ds[i]);
            }
        }
        return result;
    }

}

public class Dijkstra {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t1 = in.nextInt();
        for (int gj = 0; gj < t1; gj++) {
            int n = in.nextInt();
            int m = in.nextInt();
            long w[][] = new long[n + 1][n + 1];
            for (long[] row : w)
                Arrays.fill(row, 1000000l);
            for (int i = 0; i < m; i++) {
                int x = in.nextInt(), y = in.nextInt();
                long cmp = in.nextLong();
                if (w[x][y] > cmp) {
                    w[x][y] = cmp;
                    w[y][x] = cmp;
                }
            }
            Stack<Integer> t = new Stack<Integer>();
            int src = in.nextInt();
            for (int i = 1; i <= n; i++) {
                if (i != src) {
                    t.push(i);
                }
            }
            Stack<Integer> p = new Stack<Integer>();
            p.push(src);
            w[src][src] = 0;
            while (!t.isEmpty()) {
                int min = 989997979, loc = -1;
                for (int i = 0; i < t.size(); i++) {
                    w[src][t.elementAt(i)] = Math.min(w[src][t.elementAt(i)], w[src][p.peek()] + w[p.peek()][t.elementAt(i)]);
                    if (w[src][t.elementAt(i)] <= min) {
                        min = (int) w[src][t.elementAt(i)];
                        loc = i;
                    }
                }
                p.push(t.elementAt(loc));
                t.removeElementAt(loc);
            }
            for (int i = 1; i <= n; i++) {
                if (i != src && w[src][i] != 1000000l) {
                    System.out.print(w[src][i] + " ");
                } else if (i != src) {
                    System.out.print("-1" + " ");
                }
            }
            System.out.println();
        }
    }
}