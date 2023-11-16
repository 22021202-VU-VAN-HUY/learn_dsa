package week10;

public class BinarySearchTree_Insertion {
    class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */


    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else root.data = data;
        return root;
    }
}
