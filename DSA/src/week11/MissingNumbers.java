package week11;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MissingNumbers {
    class Result {

        /*
         * Complete the 'missingNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY arr
         *  2. INTEGER_ARRAY brr
         */

        public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
            // Write your code here
            HashSet<Integer> num = new HashSet<>(arr);
            List<Integer> result = new ArrayList<>();
            for (int i: brr){
                if (!num.contains(i)){
                    result.add(i);
                }
            }
            //Collections.sort(result);
            return result;
        }

    }
}
