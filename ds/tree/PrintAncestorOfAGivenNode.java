package ds.tree;

import java.util.Stack;

/**
 * Created by sarkarri on 4/11/17.
 */
public class PrintAncestorOfAGivenNode {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        printAncestorRecursive(root, 13);
    }

    static boolean printAncestorRecursive(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (printAncestorRecursive(root.left, key) || printAncestorRecursive(root.right, key)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }


    static void printAncestorIterative(Node root){
        Stack<Node> s = new Stack<>();
        s.push(root);


    }
}
