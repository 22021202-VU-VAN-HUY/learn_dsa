package ham;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackOfStrings {
    // khởi tạo constructor
    public StackOfStrings() {
    }

    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    // thêm phần từ vào đầu danh_sách
    public void push(String item) {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
    }

    // xóa phần tử ở đầu dand sách
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    // kiểm tra xem stack có rỗng hay không
    public boolean isEmpty() {
        return first == null;
    }

    // lấy số phần tử của stack
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

    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop());
            } else stack.push(s);
        }
    }
}
