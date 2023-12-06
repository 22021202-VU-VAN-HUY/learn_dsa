package week9;

import java.util.*;

// https://www.hackerrank.com/challenges/phone-book/problem
class JavaMap {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Map<String, Integer> people = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            people.put(name, phone);
        }

        while (in.hasNext()) {
            String s = in.nextLine();
            if (people.containsKey(s)) {
                System.out.println(s + "=" + people.get(s));
            } else {
                System.out.println("Not found");
            }
        }
    }
}
