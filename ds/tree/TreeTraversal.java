package ds.tree;

import sun.misc.LRUCache;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by sarkarri on 12/7/16.
 */
public class TreeTraversal {
    Node root;

    public static void main(String[] args) {
        TreeTraversal tt = new TreeTraversal();
        tt.root = Node.nodeBuilder();
        //tt.levelOrderTraversal(tt.root);
//        System.out.println("");
//        System.out.print("Preorder -");
//        tt.recursivePreorder(tt.root);
//        System.out.println("");
//        tt.preorderIterative(tt.root);
//        System.out.println("");
//        System.out.printf("Inorder  -");
//        tt.recursiveInorder(tt.root);
//        System.out.println();
//        tt.inorderIterative1(tt.root);
//        System.out.println();
//        tt.inorderIterative2(tt.root);
//        System.out.println();
//        tt.inorderIterative3(tt.root);

//        System.out.printf("Pstorder -");
        tt.recursivePostorder(tt.root);
        System.out.println("");
        tt.iterativePostOrder(tt.root);
    }

    public void recursivePreorder(Node root) {
        Node temp = root;
        if (temp != null) {
            System.out.printf(+temp.data + " ");
            recursivePreorder(temp.left);
            recursivePreorder(temp.right);
        }
    }

    public void preorderIterative(Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.pop();
            System.out.printf(temp.data + " ");
            if (temp.right != null)
                s.push(temp.right);
            if (temp.left != null)
                s.push(temp.left);
        }
    }

    public void recursiveInorder(Node root) {
        Node temp = root;
        if (temp != null) {
            recursiveInorder(temp.left);
            System.out.printf(+temp.data + " ");
            recursiveInorder(temp.right);
        }
    }

    public void inorderIterative1(Node root) {
        Node temp = root;
        Stack<Node> s = new Stack<>();
        s.push(temp);

        while (temp.left != null) {
            s.push(temp.left);
            temp = temp.left;
        }

        //Node node = s.pop();
        //System.out.println(node.data);

        while (!s.isEmpty()) {
            temp = s.pop();
            System.out.printf(temp.data + " ");
            if (temp.right != null) {
                temp = temp.right;

                while (temp != null) {
                    s.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    public void inorderIterative2(Node root) {
        Node temp = root;
        Stack<Node> s = new Stack<>();

        while (!s.isEmpty() || temp != null) {
            if (temp != null) {
                s.push(temp);
                temp = temp.left;
            } else {
                temp = s.pop();
                System.out.printf(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void inorderIterative3(Node root) {
        Node temp = root;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            temp = s.peek();
            if (temp.left != null) {
                s.push(temp.left);
                temp.left = null;
            } else {
                temp = s.pop();
                System.out.printf(temp.data + " ");
                if (temp.right != null)
                    s.push(temp.right);
            }
        }
    }

    public void recursivePostorder(Node root) {
        Node temp = root;
        if (temp != null) {
            recursivePostorder(temp.left);
            recursivePostorder(temp.right);
            System.out.printf(+temp.data + " ");
        }
    }

    public void iterativePostOrder(Node root) {
        Node temp = root;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            temp = s.peek();

            if (temp.left != null) {
                s.push(temp.left);
                temp.left = null;
            } else if (temp.right != null) {
                s.push(temp.right);
                temp.right = null;
            } else
                System.out.printf(s.pop().data + " ");

        }
    }


}
