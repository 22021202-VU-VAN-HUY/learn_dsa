package week3;

// Import your library

import java.util.Scanner;

// Do not change the name of the Solution class
public class Solution_fib {
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
        long n = 20;
        System.out.println(fibonacci(n));
    }
}