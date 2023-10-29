package ktra;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int dem = 1;
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                list.add(dem);
                dem++;
            } else if (x == 2) {
                int k = list.size();
                if (k<1) {
                    System.out.println(0);
                } else {
                    System.out.println(list.get(0));
                    list.remove(0);
                }
            } else if (x == 3) {
                int k = list.size() - 1;
                if (k<0) {
                    System.out.println(0);
                } else {
                    System.out.println(list.get(k));
                    list.remove(k);
                }
            } else if (x == 4) {
                System.out.println(list.size());
            } else if (x == 5) {
                int u = sc.nextInt();
                int k = list.size();
                if (u > k || k == 0) {
                    System.out.println(0);
                } else
                    System.out.println(list.get(u - 1));
            }
        }
    }
}
