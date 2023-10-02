package week4;
import java.util.ArrayList;
import java.util.Arrays;  // sử dụng các phương thức liên quan tới mảng
import java.util.List;
class SinglyLinkedListNode {
public int data;
public SinglyLinkedListNode next;


public class hackerank {
    //4

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        // Write your code here
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        if (position == 0) {
            add.next = head;
            head = add ;
        }
        else {
            int count = 0;
            SinglyLinkedListNode temp = head;
            while (temp.next!=null){
                count++;
                if (count == position){
                    add.next = temp.next;
                    temp.next = add;
                }
                temp = temp.next;

            }

        }
        return head;
    }


    //5
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        // Write your code here
        int count =0;
        SinglyLinkedListNode temp =head;
        if (position == 0) {
            head=head.next;
            return head;
        }
        while (count!=position-1){
            temp=temp.next;
            count++;
        }
        if (temp.next.next!=null){
            temp.next = temp.next.next;
        }
        else temp.next = null;
        return head;
    }

    //6
    public static void reversePrint(SinglyLinkedListNode head) {
        // Write your code here
        SinglyLinkedListNode temp = head;

        List<Integer> arr = new ArrayList<>();
        while (temp.next!=null){
            arr.add(temp.data);
            temp=temp.next;
        }
        arr.add(temp.data);
        for (int i=arr.size()-1;i>=0;i--){
            System.out.println(arr.get(i));
        }
    }

    //7
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        // Write your code here

        SinglyLinkedListNode temp = head;
        if ( head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //8
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode temp1 =head1;
        SinglyLinkedListNode temp2 = head2;
        int count1=0;
        int count2=0;
        while (count1==count2){
            if (temp1.data == temp2.data){
                if (head1!=null){
                    head1=head1.next;
                    count1++;
                }
                if (head2!=null){
                    head2=head2.next;
                    count2++;
                }
                else break;
            }
            else return false;
        }
        if (count1==count2) return true;
        else   return false;
    }

    //9
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head = head1;
        if (head1.data <= head2.data) {
            head.data= head1.data;
            head1= head1.next;
        }
        else {
            head.data = head2.data;
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
        }
        return head;
    }

    //10
    public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode temp = head;
        int count =0;
        while (temp!=null){
            count ++;
            temp=temp.next;
        }
        int re = (count-1) - positionFromTail;
        count=0;
        SinglyLinkedListNode temp1 = head;
        while (count!=re){
            count++;
            temp1=temp1.next;
        }
        return temp1.data;
    }
}


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
}
