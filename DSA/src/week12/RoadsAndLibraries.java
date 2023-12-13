package week12;

// https://www.hackerrank.com/challenges/torque-and-development/problem

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

public class RoadsAndLibraries {
    class Result {

        static class UnionFind {
            private int[] id;
            private int[] rank;

            public UnionFind(int n) {
                id = new int[n + 1];
                rank = new int[n + 1];

                for (int i = 1; i <= n; i++) {
                    id[i] = i;
                    rank[i] = 1;
                }
            }

            public int find(int x) {
                if (id[x] != x) {
                    id[x] = find(id[x]);
                }
                return id[x];
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX != rootY) {
                    if (rank[rootX] > rank[rootY]) {
                        id[rootY] = rootX;
                    } else if (rank[rootX] < rank[rootY]) {
                        id[rootX] = rootY;
                    } else {
                        id[rootY] = rootX;
                        rank[rootX]++;
                    }
                }
            }
        }

        public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
            if (c_lib <= c_road) {
                return (long) n * c_lib;
            }
            
            UnionFind uf = new UnionFind(n);

            for (List<Integer> road : cities) {
                int city1 = road.get(0);
                int city2 = road.get(1);

                uf.union(city1, city2);
            }

            Set<Integer> components = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                components.add(uf.find(i));
            }

            return (long) components.size() * c_lib // số thành phần liên thông * cost_1lib
                    + (n - components.size()) * c_road;
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

