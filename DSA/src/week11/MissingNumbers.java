package week11;

// https://www.hackerrank.com/challenges/missing-numbers/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import static java.util.stream.Collectors.toList;


public class MissingNumbers {
    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : brr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            countMap.put(num, countMap.get(num) - 1);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            int count = e.getValue();
            if (count > 0) {
                result.add(e.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> brr = new ArrayList<>();
        for (int i=0;i<m;i++){
            brr.add(sc.nextInt());
        }

        List<Integer> result = missingNumbers(arr,brr);
        for (Integer temp :result){
            System.out.print(temp+" ");
        }
    }
}

/*
    10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204

204 205 206
 */