import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int count = 0; // Số lần thực hiện lệnh union
        int result = -1; // Lưu kết quả cuối cùng
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                count++;
            }

            if (count == N - 1) {
                result = count;
                break;
            }

            if (p<0 || q<0) {
                break;
            }
        }
        if (result == N - 1) {
            StdOut.println(result);
        } else {
            StdOut.println("FAILED");
        }
    }
}
