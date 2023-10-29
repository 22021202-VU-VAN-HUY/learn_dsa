package week3.Sum;

import java.util.*;

// https://www.hackerrank.com/challenges/pairs/problem

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        Collections.sort(arr);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int maxx = arr.get(i) + k;
            //int j=i;
            for (int j = i; j < n; j++) {
                if (arr.get(j) == maxx) {
                    answer++;
                    break;
                } else if (arr.get(j) > maxx) break;
            }
        }
        return answer;
    }
}
