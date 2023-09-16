package week3.Sum;

//package edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.*;
public class ThreeSum {


    // Do not instantiate.
    private ThreeSum() { }

    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    }

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args)  {
        In in = new In("C:\\Users\\FPTSHOP\\Desktop\\learn_java\\DSA\\src\\week3\\text_test\\4Kints.txt");
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println("all: " +count);
    }
}

// turn 1: time = 11.08  ;  4039
// turn 2: time = 11.908 ;  4039
// turn 3: time = 11.964 ;  4039