package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int count = 0; // Số lần thực hiện lệnh union
        int result = -1; // Lưu kết quả cuối cùng
        boolean end_connect =  false;
        int number = 0; // số dòng
        while (!StdIn.isEmpty()) {
            number ++;
            int p = StdIn.readInt();
            if (p<0) {end_connect = true;break;}
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                count++;
            }
            if (count == N-1 && !end_connect) {
                result = number;
                end_connect = true;
                break;
            }


        }
        if (result != -1) {
            StdOut.println("");
            StdOut.println(number);
        } else {
            StdOut.println("FAILED");
        }
    }
}
