package ktra;

import java.util.Scanner;

public class SuperHardUnionFind {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] id = new int[n+1];
        int[] countid = new int[n+1];
        int nhom = n;
        for (int i = 1; i <= n; i++) {
            id[i] = i;
            countid[i] = 1;
        }
        //System.out.println(countid[1]);
        //System.out.println("hello");
        int m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (id[a]!=id[b]){
                    int x =id[b];
                    countid[a]+=countid[b];
                    countid[b]=countid[a];
                    for (int j=1;j<=n;j++){
                        if (id[j]==x||id[j]==id[a]){
                            id[j]=id[a];
                            countid[j]=countid[a];
                        }
                    }
                    nhom--;
                }

            } else if (k == 2) {
                System.out.println(nhom);
            } else if (k == 3) {
                int x = sc.nextInt();
                System.out.println(countid[x]);
            } else if (k == 4) {
                int max = 1;
                for (int j = 1; j <= n; j++) {
                    if (countid[j] > max) {
                        max = countid[j];
                    }
                }
                System.out.println(max);
            }
        }
    }
}
