package week11;

import java.util.HashSet;
import java.util.List;

public class pair {
    class Result {

        /*
         * Complete the 'pairs' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY arr
         */

        public static int pairs(int k, List<Integer> arr) {
            // Write your code here
            int count =0;
            HashSet<Integer> num = new HashSet<>();
            for (Integer i: arr){
                if (num.contains(i+k)){
                    count ++;
                }
                if (num.contains(i-k)){
                    count++;
                }
                num.add(i);
            }
            return count;
        }

    }
}
