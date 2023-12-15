package Vebo;

import java.util.Scanner;

public class Vebo5Query2 {

    public static int[] arr = new int[3000000];
    public static int[] minn = new int[3000000];

    public static void build(int l, int r, int id) {
        if (l == r) {
            minn[id] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        minn[id] = Math.min(minn[2 * id], minn[2 * id + 1]);
    }

    public static int checkmin(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return 1000000001;
        if (u <= l && r <= v) return minn[id];
        int mid = (l + r) / 2;
        int left = checkmin(l, mid, 2 * id, u, v);
        int right = checkmin(mid + 1, r, 2 * id + 1, u, v);
        return Math.min(left, right);
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
            int temp = sc.nextInt();
            if (temp==1){
                int result = checkmin(1, n, 1, sc.nextInt(), sc.nextInt());
                System.out.println(result);
            }
            else if (temp==2){
                arr[sc.nextInt()]=sc.nextInt();
                build(1,n,1);
            }
        }
    }
}
