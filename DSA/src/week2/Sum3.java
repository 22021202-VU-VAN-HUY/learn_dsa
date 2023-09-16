package week2;
import edu.princeton.cs.algs4.*;

public class Sum3 {
    public static void main(String[] args) {
        //In in = new In("C:\\Users\\FPTSHOP\\Desktop\\learn_java\\algs4-data\\4Kints.txt");
        In in = new In("C:\\Users\\FPTSHOP\\Desktop\\learn_java\\DSA\\src\\week2\\4Kints.txt");
        // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a

        // xử lý dữ liệu trong mảng a
        int n = a.length;
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                for (int k = j +1 ; k < n ; k++){
                    if ( a[i] + a[j] +a[k] ==0 ) System.out.println(a[i]+" "+a[j] + " "+a[k]);
                }
            }
        }

        //StdArrayIO.print(a); // in mảng ra màn hình
    }
}

