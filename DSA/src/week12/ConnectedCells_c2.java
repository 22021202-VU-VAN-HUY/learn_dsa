package week12;

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

// https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem


public class ConnectedCells_c2 {
    class Result {
        /*
         * Complete the 'connectedCell' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
         */

        public static int connectedCell(List<List<Integer>> matrix) {
            // Write your code here
            int max = 0;
            int rows = matrix.size();
            int cols = matrix.get(0).size();
            boolean[][] visited = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix.get(i).get(j) == 1 && !visited[i][j]) {
                        int currentRegionSize = dfs(matrix, visited, i, j);
                        max = Math.max(max, currentRegionSize);
                    }
                }
            }

            return max;
        }

        private static boolean check(int r, int c, int N, int M) {
            return r >= 0 && r < N && c >= 0 && c < M;
        }

        private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int row, int col) {
            int rows = matrix.size();
            int cols = matrix.get(0).size();
            int size = 1;

            visited[row][col] = true;

            int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < 8; i++) {
                int r = row + dr[i];
                int c = col + dc[i];

                if (check(r, c, rows, cols)
                        && matrix.get(r).get(c) == 1 && !visited[r][c]) {
                    size += dfs(matrix, visited, r, c);
                }
            }

            return size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
