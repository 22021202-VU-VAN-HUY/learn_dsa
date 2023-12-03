package week4;

import java.io.*;

// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class Merge_two_sorted_linked_lists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        //SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        SinglyLinkedListNode head = null;
        if (head1.data <= head2.data) {
            head=head1;
            head1= head1.next;
        }
        else {
            head=head2;
            head2 = head2.next;
        }
        SinglyLinkedListNode temp=head;
        while (head1!=null || head2!=null){
            if (head1 == null) {temp.next = head2;head2=head2.next;}
            else if (head2 == null) {temp.next=head1;head1=head1.next;}
            else if (head1.data <= head2.data) {
                temp.next=head1;
                head1=head1.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp=temp.next;
        }
        return head;
    }
}
