package week2;


import edu.princeton.cs.algs4.*;

public class Sum2 {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\FPTSHOP\\Desktop\\learn_java\\algs4-data\\4Kints.txt");
        //In in = new In("C:\\Users\\FPTSHOP\\Desktop\\learn_java\\algs4-data\\0test.txt");
        // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a

        // xử lý dữ liệu trong mảng a
        int n = a.length;
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                if ( a[i] + a[j] ==0 ) System.out.println(a[i]+" "+a[j]);
            }
        }

        //StdArrayIO.print(a); // in mảng ra màn hình
    }
}

