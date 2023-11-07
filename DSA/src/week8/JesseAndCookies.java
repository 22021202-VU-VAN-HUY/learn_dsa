package week8;

import java.util.List;
import java.util.PriorityQueue;

// https://www.hackerrank.com/challenges/jesse-and-cookies/problem
public class JesseAndCookies {
    class Result {

        /*
         * Complete the 'cookies' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY A
         */

        public static int cookies(int k, List<Integer> A) {
            // Write your code here
            PriorityQueue<Integer> p = new PriorityQueue<>(A);
            int count = 0;
            if (p.size() >= 2) {
                int number1 = p.poll();
                while (number1 < k) {
                    if (p.isEmpty()) return -1;
                    else {
                        int number2 = p.poll();
                        p.add(number1 + 2 * number2);
                        number1 = p.poll();
                        count++;
                    }
                }
                return count;
            } else if (p.size() == 1) {
                int x = p.poll();
                if (x >= k) return 0;
            }
            return -1;
        }
    }
}
