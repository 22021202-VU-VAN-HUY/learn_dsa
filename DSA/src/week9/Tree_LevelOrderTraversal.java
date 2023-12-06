package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// duyệt từng hàng từ trên -> dưới
// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
public class Tree_LevelOrderTraversal {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class Solution {

        public static void levelOrder(Node root) {
            if (root == null)
                return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
        }

        public static Node insert(Node root, int data) {
            if(root == null) {
                return new Node(data);
            } else {
                Node cur;
                if(data <= root.data) {
                    cur = insert(root.left, data);
                    root.left = cur;
                } else {
                    cur = insert(root.right, data);
                    root.right = cur;
                }
                return root;
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            Node root = null;
            while(t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            scan.close();
            levelOrder(root);
        }
    }
}
