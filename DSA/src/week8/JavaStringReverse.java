package week8;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-string-reverse/problem
public class JavaStringReverse {
    public static boolean check(String s) {
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        if (check(string)) System.out.println("Yes");
        else System.out.println("No");
    }
}