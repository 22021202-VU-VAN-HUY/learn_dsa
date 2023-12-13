package week12;

// https://www.hackerrank.com/challenges/torque-and-development/problem

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RoadsAndLibraries_c2 {
    class Result {
        private static int dfs(int city, List<List<Integer>> temp, boolean[] visited) {
            int size = 1;
            visited[city] = true;

            for (int near : temp.get(city)) {
                if (!visited[near]) {
                    size += dfs(near, temp, visited);
                }
            }
            return size;
        }

        public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
            // If building a library is cheaper than building a road, build a library in each city
            if (c_lib <= c_road) {
                return (long) n * c_lib;
            }

            // Build adjacency list for cities
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (List<Integer> road : cities) {
                int c1 = road.get(0);
                int c2 = road.get(1);
                adjList.get(c1).add(c2);
                adjList.get(c2).add(c1);
            }

            boolean[] visited = new boolean[n + 1];
            long totalCost = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    int componentSize = dfs(i, adjList, visited);
                    totalCost += c_lib + (componentSize - 1) * c_road;
                }
            }

            return totalCost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

