package week10;

// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
public class HeightOfABinaryTree {
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

    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    public static int height(Node root) {
        // Write your code here.
        Node temp = root;
        if (temp == null) return -1;
        return Math.max(height(temp.left), height(temp.right)) + 1;
    }
}
