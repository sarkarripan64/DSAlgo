package ds.stack;

import ds.tree.Node;

import java.util.Stack;

/**
 * Created by sarkarri on 4/6/17.
 */
public class PostOrderTraversalUsingTwoStack {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        postOderTraversal(root);
    }

    static void postOderTraversal(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            Node node = s1.pop();
            s2.push(node);

            if (node.left != null)
                s1.push(node.left);

            if (node.right != null)
                s1.push(node.right);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }
}
