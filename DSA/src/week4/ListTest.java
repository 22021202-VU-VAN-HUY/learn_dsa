package week4;

import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) {
        LinkedList <Integer> li = new LinkedList<Integer>();


        for (int i = 0; i < 10; i++) {
            li.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(" "+ li.get(i));
        }
     }
}
