package week9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-hashset/problem
public class JavaHashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        Set<String> temp = new HashSet<>();
        for (int i=0;i<t;i++){
            temp.add(pair_right[i]+" "+pair_left[i]);
            System.out.println(temp.size());
        }
    }
//    5
//    john tom
//    john mary
//    john tom
//    mary anna
//    mary anna
}
