package week13;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class Prims {


    class Result {

        /*
         * Complete the 'prims' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. 2D_INTEGER_ARRAY edges
         *  3. INTEGER start
         */
        static class Cost implements Comparable<Cost> {
            public int r, v;

            public Cost(int cost, int vertex) {
                r = cost;
                v = vertex;
            }

            @Override
            public int compareTo(Cost c) {
                if (r < c.r) return -1;
                if (r > c.r) return 1;
                if (v < c.v) return -1;
                if (v > c.v) return 1;
                return 0;
            }
        }
        public static int prims(int n, List<List<Integer>> edges, int start) {
            // Write your code here
            boolean[] marked = new boolean[n + 1];
            PriorityQueue<Cost> p = new PriorityQueue<>();

            p.add(new Cost(0, start));
            int minn = 0;

            while (!p.isEmpty()) {
                Cost temp = p.poll();
                int vx = temp.v;
                if (marked[vx]) {
                    continue;
                }
                minn += temp.r;
                marked[vx] = true;

                for (List<Integer> edge : edges) {
                    int u = edge.get(0);
                    int v = edge.get(1);
                    int weight = edge.get(2);

                    if (u == vx && !marked[v]) {
                        p.add(new Cost(weight, v));
                    } else if (v == vx && !marked[u]) {
                        p.add(new Cost(weight, u));
                    }
                }
            }
            return minn;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

