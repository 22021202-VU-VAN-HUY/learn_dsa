package week10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/self-balancing-tree/problem
public class SelfBalancingTree {

    static class Node {
        int val;
        Node left, right;
        int ht;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.ht = 0;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        return root.ht;
    }

    public static void updateHeight(Node node) {
        if (node != null) {
            node.ht = Math.max(height(node.left), height(node.right)) + 1;
        }
    }

    public static Node rotateLeft(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;

        updateHeight(root);
        updateHeight(temp);
        return temp;
    }

    public static Node rotateRight(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;

        updateHeight(root);
        updateHeight(temp);
        return temp;
    }

    public static int balance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    public static Node insert(Node root, int new_val) {
        if (root == null) {
            return new Node(new_val);
        }

        if (new_val < root.val) {
            root.left = insert(root.left, new_val);
        } else if (new_val > root.val) {
            root.right = insert(root.right, new_val);
        } else {
            return root;
        }

        updateHeight(root);

        int balance = balance(root);
        if (balance > 1) {
            if (new_val < root.left.val) {
                // Left-Left
                return rotateRight(root);
            } else {
                // Left-Right
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }
        if (balance < -1) {
            if (new_val > root.right.val) {
                // Right-Right
                return rotateLeft(root);
            } else {
                // Right-Left
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "(BF=" + balance(root) + ") ");
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.val + "(BF=" + balance(root) + ") ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node node = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            node = insert(node, val);
        }
        int val = sc.nextInt();
        node = insert(node, val);
        node = insert(node, val);
        inOrder(node);
        System.out.print("\n");
        preOrder(node);
    }
}


/*
4
3 2 4 5
6
 */