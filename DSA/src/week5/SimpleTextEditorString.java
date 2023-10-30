package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/simple-text-editor/problem

public class SimpleTextEditorString {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            if (next == 1) {
                String s = sc.next();
                if (result.isEmpty()) {
                    result.add(s);
                } else {
                    String temp = result.get(result.size() - 1);
                    temp += s;
                    result.add(temp);
                }
            } else if (next == 2) {
                int k = sc.nextInt();
                String s = result.get(result.size() - 1);
                String temp = "";
                for (int j = 0; j < s.length() - k; j++) {
                    temp += s.charAt(j);
                }
                result.add(temp);
            } else if (next == 3) {
                int k = sc.nextInt();
                System.out.println((result.get(result.size()-1)).charAt(k-1));
            } else {
                result.remove(result.size() - 1);
            }
        }
    }
}
