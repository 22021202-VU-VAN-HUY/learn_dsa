package ham.week1_11;

import java.io.*;
import java.util.*;



public class Solution {

    static class Stack {

        public Stack() {
        }

        private Node first = null;

        private class Node {
            int item;
            Node next;
        }


        public void push(int item) {
            Node oldNode = first;
            while (oldNode.next!=null||oldNode!=null){
                oldNode=oldNode.next;
            }
            Node s = new Node();
            s.item=item;
            oldNode.next=s;
        }


        public int pop() {
            int item = first.item;
            first = first.next;
            return item;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            Node old1 = first;
            if (old1 == null) {
                return 0;
            }
            int dem = 1;
            if (old1.next != null) {
                dem++;
                old1 = old1.next;
            }
            return dem;
        }

        public void show(){
            if (first!=null){System.out.println(first.item);}
        }

    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack s = new Stack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int check = sc.nextInt();
            if (check == 1) {
                int a = sc.nextInt();
                s.push(a);
            }
            else if (check ==2){
                s.pop();
            }
            else s.show();
        }
    }
}
