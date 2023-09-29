// Import your library
package week5;
import java.util.Scanner;

// Do not change the name of the Solution class
public class Solution {
    // Type your main code here

    /**
     * fib.
     *
     * @param n nth fibonacci element
     * @return fibonacci n
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        long[] fib = new long[101];
        //int k = (int) n;
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= 100; i++) {
            if (Long.MAX_VALUE - fib[i - 1] >= fib[i - 2]) {
                fib[i] = fib[i - 1] + fib[i - 2];
            } else {
                fib[i] = Long.MAX_VALUE;
            }
        }
        return fib[(int) n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = fibonacci(n);
        System.out.println(result);
        System.out.println(Long.MAX_VALUE);

    }
}