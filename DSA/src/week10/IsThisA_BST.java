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


    boolean checkBST(Node root) {
        if (root == null) return true;
        if (root.left == null) {
            if (root.right != null)
                return checkBST(root.right) && (root.data < root.right.data);
            return true;
        } else if (root.right == null) {
            if (root.left != null)
                return checkBST(root.left) && (root.data > root.left.data);
            return true;
        }
        if (root.data > root.left.data && root.data < root.right.data) {
            return checkBST(root.left) && checkBST(root.right);
        }
        return false;
    }
}
