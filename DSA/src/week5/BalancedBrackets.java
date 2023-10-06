package week5;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// st.push(c)
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
