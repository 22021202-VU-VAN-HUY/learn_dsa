package week5;

import java.util.*;

// https://www.hackerrank.com/challenges/balanced-brackets/problem

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> ch = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                ch.push(c);
            } else {
                if (ch.empty()) {
                    return "NO";
                }
                char top = ch.pop();
                if (top == '{' && c != '}' || top == '[' && c != ']' || top == '(' && c != ')'){
                    return "NO";
                }
            }
        }
        if (ch.empty()){
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {

    }
}
