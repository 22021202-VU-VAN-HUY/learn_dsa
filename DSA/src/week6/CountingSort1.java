package week6;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/countingsort1/problem
class CountingSort1 {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        int n = arr.size();
        for (int i = 0; i < 100; i++) {
            list.add(0);
        }
        for (int i = 0; i < n; i++) {
            int temp = arr.get(i);
            int next = list.get(temp);
            list.set(temp, next + 1);
        }
        return list;
    }
}
