package ham.week1_11;

public class Queue<Item> {
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
}
