package week4;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
public class Print_in_Reverse {
    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    class SinglyLinkedList {
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

    class SinglyLinkedListPrintHelper {
        public static void printList(SinglyLinkedListNode node, String sep) {
            while (node != null) {
                System.out.print(node.data);

                node = node.next;

                if (node != null) {
                    System.out.print(sep);
                }
            }
        }
    }

    class Result {

        /*
         * Complete the 'reversePrint' function below.
         *
         * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
         */

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */

        public static void reversePrint(SinglyLinkedListNode head) {
            // Write your code here
            SinglyLinkedListNode temp = head;

            List<Integer> arr = new ArrayList<>();
            while (temp.next != null) {
                arr.add(temp.data);
                temp = temp.next;
            }
            arr.add(temp.data);
            for (int i = arr.size() - 1; i >= 0; i--) {
                System.out.println(arr.get(i));
            }
        }

    }

}
