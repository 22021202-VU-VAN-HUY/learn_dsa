package week3.Sum;
import java.util.Arrays;  // sử dụng các phương thức liên quan tới mảng
//package edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.*;
public class ThreeSum_binary {
    // Do not instantiate.
    private ThreeSum_binary() { }

    public static int check (int[]a , int number, int j){
        int max = a.length-1;
        int min = j+1;
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

    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = check(a,-(a[i]+a[j]),j);
                if (k!=-1) System.out.println(a[i]+ " "+a[j]+" "+a[k]);
            }
        }
    }

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = check(a,-(a[i]+a[j]),j);
                if (k!=-1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)  {
        String path ="C:\\Users\\FPTSHOP\\Desktop\\learn_java\\DSA\\src\\week3\\text_test\\4Kints.txt";
        In in = new In(path);
        int[] a = in.readAllInts();
        Arrays.sort(a);
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println("all: " +count);
    }
}

// turn 1: time = 0.203 ;  4039
// turn 2: time = 0.219 ;  4039
// turn 3: time = 0.218 ;  4039