package week10;

import java.util.LinkedList;

// https://www.hackerrank.com/challenges/is-binary-search-tree/problem
public class IsThisA_BST {
    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
    */
    class Node {
        int data;
        Node left;
        Node right;
    }

    public static int arr[] = new int[Integer.MAX_VALUE];
    static int si = 0;

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        arr[++si] = root.data;
        inorder(root.right);
    }

    boolean checkBST(Node root) {
        inorder(root);
        for (int i = 0; i < si; i++) {
            if (arr[i] >= arr[i + 1]) return false;
        }
        return true;
    }
}
