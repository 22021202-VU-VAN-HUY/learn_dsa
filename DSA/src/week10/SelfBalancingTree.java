package week10;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/self-balancing-tree/problem
public class SelfBalancingTree {

    /* Node is defined as :
    class Node
    int val;
    Node left;
    Node right;
    int ht;
    */
    class Node {
        int val;
        Node left;
        Node right;
        int ht;

        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        } else if (root.val > val) {
            root.left = insert(root.left, val);
        } else root.val = val;
        return root;
    }

    public void updateHight(Node node) {

    }

    public Node RotateLeft(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;

        updateHight(root);
        updateHight(temp);

        return temp;
    }

//    public Node RotateRight(Node root) {
//
//        public Node insertAVL (Node root,int val){
//            if (root == null) {
//                root = new Node(val);
//                root.left = null;
//                root.right = null;
//                root.ht = 0;
//            } else {
//                if (val < root.val) {
//                    root.left = insert(root.left, val);
//                    if (get_height(root.left) - get_height(root.right) == 2) {
//                        if (val > root.left.val) {
//                            root.left = RotateRight(root.left);
//                        }
//                        root = RotateLeft(root);
//                    }
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

    }
}
