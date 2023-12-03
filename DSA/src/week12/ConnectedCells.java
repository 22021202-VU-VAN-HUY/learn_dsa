package week12;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedCells {
    class Cell {
        public int r, c;

        public Cell(int i, int j) {
            r = i;
            c = j;
        }
    }

    static int[][] grid;
    static boolean[][] visited;
    static int N, M;

    static int[] x = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static int count_connected(int row, int col) {
        int cnt = 1;
        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            int r = row + x[i];
            int c = col + y[i];
            if (check(r, c) && grid[r][c] == 1 && !visited[r][c]) {
                cnt += count_connected(r, c);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }

        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }
        System.out.println(max);
    }
}
