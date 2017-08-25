package ds.tree.bst;

import ds.tree.Node;
import ds.tree.bst.BinarySearchTree;

import java.util.Stack;

/**
 * Created by sarkarri on 12/27/16.
 */
public class KthHighestElementBST {
    static int i = 0;

    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.getBST();
        System.out.println("kth high " + findKthHighestRecursive(bst.root, 8));
        System.out.println("iter " + findKthHighestIterative(bst.root, 8));
        System.out.println("findKthHighestIterative2 " + findKthHighestIterative2(bst.root, 8));
    }

    static int findKthHighestRecursive(Node root, int k) {
        if (root == null)
            return -1;
        int leftOver = findKthHighestRecursive(root.left, k);
        i++;
        if (i == k)
            return root.data;
        if (leftOver == -1)
            return findKthHighestRecursive(root.right, k);

        return leftOver;
    }

    static int findKthHighestIterative(Node root, int k) {
        Stack<Node> s = new Stack<>();
        Node temp = root;
        int j = 0;
        while (temp != null) {
            s.push(temp);
            temp = temp.left;
        }

        while (!s.isEmpty()) {
            temp = s.pop();
            j++;
            if (j == k)
                return temp.data;

            if (temp.right != null) {
                temp = temp.right;

                while (temp != null) {
                    s.push(temp);
                    temp = temp.left;
                }
            }

        }
        return -1;
    }

    static int findKthHighestIterative2(Node root, int k) {
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.peek();
            if (temp.left != null) {
                s.push(temp.left);
                temp.left = null;
            } else {
                Node node = s.pop();
                k--;
                if (0 == k)
                    return node.data;
                if (node.right != null) {
                    s.push(node.right);
                }
            }
        }

        return -1;
    }
}
