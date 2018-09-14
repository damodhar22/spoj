package zero;

import java.util.Stack;

public class IsThisBinarySearchTree {
    // The  value of every node in a node's left subtree is less than the data value of that node.
    // The  value of every node in a node's right subtree is greater than the data value of that node.
    // The  value of every node is distinct.

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {

        if (root == null) {
            return true;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()){

            Node node = stack.pop();
            Node left = node.left;
            Node right = node.right;

            if(left != null){
                if(left.data > node.data) {
                    return false;
                }else {
                    stack.push(left);

                }
            }

            if(right != null){
                if( right.data < node.data) {
                    return false;

                }else {
                    stack.push(right);
                }
            }

        }
        return true;
    }
}
