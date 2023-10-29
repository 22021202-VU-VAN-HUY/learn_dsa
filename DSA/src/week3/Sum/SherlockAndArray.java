package week3.Sum;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/sherlock-and-array/problem

public class SherlockAndArray {

    public static String result(List<Integer> a) {
        if (a == null) {
            return "NO";
        }
        if (a.size() == 1) {
            return "YES";
        }
        int sum = 0; // sum

        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
        }

        int sumL = 0;
        for (int i = 0; i < a.size(); i++) {
            if (i == 0) {
                sumL += 0;
            } else {
                sumL += a.get(i - 1);
            }
            int sumR = sum - sumL - a.get(i);
            if (sumL == sumR) {
                return "YES";
            }
        }
        return "NO";
    }
}
