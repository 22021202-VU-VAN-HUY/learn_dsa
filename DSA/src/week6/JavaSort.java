package week6;

import java.util.*;

// https://www.hackerrank.com/challenges/java-sort/problem
public class JavaSort {
    public static class Person {
        private int n;
        private String name;
        private Double gpa;

        public Person() {
        }

        public Person(int n, String name, Double gpa) {
            this.n = n;
            this.name = name;
            this.gpa = gpa;
        }

        public void setN(int n) {
            this.n = n;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGpa(Double gpa) {
            this.gpa = gpa;
        }
    }

    static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person person1, Person person2) {
            int gpa = Double.compare(person1.gpa, person2.gpa);

            if (gpa != 0) {
                return gpa;
            } else {
                int name = person1.name.compareTo(person2.name);
                if (name != 0) {
                    return -name;
                }
                return Integer.compare(person1.n, person2.n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> list = new ArrayList<>();
//        int[] a1 = new int[n];
//        String[] a2 = new String[n];
//        Double[] a3 = new Double[n];
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            String name = sc.next();
            Double gpa = sc.nextDouble();
            Person p = new Person(N, name, gpa);
            list.add(p);
        }
        Collections.sort(list, new PersonComparator());
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(list.get(i).name);
        }
    }

}

/*
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
 */
