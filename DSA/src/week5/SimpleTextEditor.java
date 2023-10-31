package week5;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/simple-text-editor/problem

public class SimpleTextEditor {

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            if (next == 1) {
                String string = sc.next();
                if (s.isEmpty()) {
                    s.push(string);
                } else {
                    String temp = s.peek();
                    temp += string;
                    s.add(temp);
                }
            } else if (next == 2) {
                int k = sc.nextInt();
                String temp = s.peek();
                String res = "";
                for (int j = 0; j < temp.length() - k; j++) {
                    res += temp.charAt(j);
                }
                s.push(res);

            } else if (next == 3) {
                int k = sc.nextInt();
                System.out.println(s.peek().charAt(k - 1));
            } else {
                s.pop();
            }
        }
    }

}
