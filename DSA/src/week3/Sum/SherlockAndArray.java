package week3.Sum;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/sherlock-and-array/problem

public class SherlockAndArray {

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        if (arr == null ) {
            return "NO";
        }
        if(arr.size() == 1){
            return "YES";
        }
        int sum =0; // sum

        for (int i=0;i<arr.size();i++){
            sum+=arr.get(i);
        }

        int sumL = 0;
        for(int i=0; i<arr.size(); i++){
            if(i==0){
                sumL +=0;
            }else{
                sumL+=arr.get(i-1);
            }
            int sumR = sum - sumL-arr.get(i);
            if(sumL == sumR){
                return "YES";
            }
        }
        return "NO";
    }
}
