package week3.Sum;

import java.util.Collections;
import java.util.List;

public class NewYearChaos {
    class Result {

        /*
         * Complete the 'minimumBribes' function below.
         *
         * The function accepts INTEGER_ARRAY q as parameter.
         */

        public static void minimumBribes(List<Integer> q) {
            // Write your code here
            int answer = 0;

            for (int i = q.size() - 1; i >= 0; i--) {
                int check = q.get(i);


                if (check - (i + 1) > 2) {
                    System.out.println("Too chaotic");
                    return;
                }

                for (int j = Math.max(0, check - 2); j < i; j++) {
                    if (q.get(j) > check) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

    }
}
