package week3.Sum;
import java.util.Arrays;  // làm việc với mảng (sort)
import java.util.Random;  // sinh ngẫu  nhiên
import java.util.Scanner;

public class binary_search {

    public static int binarySearch(int[] a, int number) {
        int max = a.length-1;
        int min = 0;
        while (min <= max) {
            int mid = (max+min)/2;
            if (a[mid] == number) return mid;
            else if (a[mid] > number) {
                max = mid-1;
            }
            else min = mid +1;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /**
        int n = sc.nextInt();  // khởi tạo size mảng
        int[] a = new int[n];  // khởi tạo mảng
        Random random = new Random();
        for (int i=0;i<n;i++) a[i] = random.nextInt((n) + 0);
        Arrays.sort(a);

         for (int i=0;i<n;i++){
         System.out.println(a[i]);
         }
         */
        int a[] = new int[]{3,5,7,12,15,31,40,45};
        System.out.println("end");
        int number = sc.nextInt();
        System.out.println(binarySearch(a,number));

    }
}
