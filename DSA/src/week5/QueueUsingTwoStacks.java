package week5;
import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {

    private static class Queue<Item> {
        private Node first,last;
        private class Node{
            Item item;
            Node next;
        }

        public boolean isEmpty(){
            return first==null;
        }

        public void enqueue(Item item){
            Node odlLast = last;
            last = new Node();
            last.item=item;
            last.next = null;
            if (isEmpty()) first =last;
            else odlLast.next=last;
        }

        public Item dequeue(){
            Item item = first.item;
            first=first.next;
            if (isEmpty()) last = null;
            return item;
        }
        public void show(){
            System.out.println(first.item);
        }
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Queue s = new Queue<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int check = sc.nextInt();
            if (check == 1) {
                int a = sc.nextInt();
                s.enqueue(a);
            }
            else if (check ==2){
                s.dequeue();
            }
            else s.show();
        }
    }
}
