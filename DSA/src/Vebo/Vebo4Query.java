package Vebo;

import java.io.*;
import java.util.*;

public class Vebo4Query {

    public static int[] arr = new int[3000000];
    public static int[] maxx = new int[3000000];

    public static void build(int l, int r, int id) {
        if (l == r) {
            maxx[id] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        maxx[id] = Math.max(maxx[2 * id], maxx[2 * id + 1]);
    }

    public static int checkmax(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return Integer.MIN_VALUE;
        if (u <= l && r <= v) return maxx[id];
        int mid = (l + r) / 2;
        int left = checkmax(l, mid, 2 * id, u, v);
        int right = checkmax(mid + 1, r, 2 * id + 1, u, v);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        build(1, n, 1);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int result = checkmax(1, n, 1, sc.nextInt(), sc.nextInt());
            System.out.println(result);
            //  }
        }
    }
}
