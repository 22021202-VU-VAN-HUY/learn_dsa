package week5;

// https://www.hackerrank.com/challenges/equal-stacks/problem

import java.util.*;

class Equal_Stacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
    public static int getSum(List<Integer> h1) {
        int Sum = 0;
        for (int i = 0; i < h1.size(); i++) {
            Sum += h1.get(i);
        }
        return Sum;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int sum1 = getSum(h1);
        int sum2 = getSum(h2);
        int sum3 = getSum(h3);
        while (!(sum1 == sum2 && sum2 == sum3)) {
            int minsum = Math.min(sum1, Math.min(sum2, sum3));
            if (sum1 > minsum) {
                if (h1.isEmpty()) return 0;
                sum1 -= h1.get(0);
                h1.remove(0);
            }
            if (sum2 > minsum) {
                if (h2.isEmpty()) return 0;
                sum2 -= h2.get(0);
                h2.remove(0);
            }
            if (sum3 > minsum) {
                if (h3.isEmpty()) return 0;
                sum3 -= h3.get(0);
                h3.remove(0);
            }
        }
        return sum1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            h1.add(sc.nextInt());
        }
        for (int i = 0; i < n2; i++) {
            h2.add(sc.nextInt());
        }
        for (int i = 0; i < n3; i++) {
            h3.add(sc.nextInt());
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);
    }
}

