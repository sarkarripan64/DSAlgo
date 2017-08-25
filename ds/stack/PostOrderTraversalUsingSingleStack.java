package ds.stack;

import ds.tree.Node;

import java.util.Stack;

/**
 * Created by sarkarri on 4/6/17.
 */
public class PostOrderTraversalUsingSingleStack {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        //postOrderTraversal(root);
        postOrderTraversalWithVisited(InnerNode.builder());
    }

    static void postOrderTraversal(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.peek();
            boolean isSubtreesFinished = (node.left == root || node.right == root);
            boolean isLeaf = (node.left == null && node.right == null);

            if (isLeaf || isSubtreesFinished) {
                System.out.print(s.pop().data + " ");
                root = node;
            } else {

                if (node.right != null) {
                    s.push(node.right);
                }

                if (node.left != null) {
                    s.push(node.left);
                }
            }
        }
    }

    static void postOrderTraversalWithVisited(InnerNode root) {
        Stack<InnerNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            InnerNode temp = s.peek();

            if (temp.left != null && !temp.left.visited) {
                s.push(temp.left);
            } else if (temp.right != null && !temp.right.visited) {
                s.push(temp.right);
            } else {
                System.out.print(s.pop().data + " ");
                temp.visited = true;
            }
        }
    }

    static class InnerNode {
        int data;
        boolean visited;
        InnerNode left, right;

        InnerNode(int data) {
            this.data = data;
        }

        static InnerNode builder() {
            InnerNode in = new InnerNode(1);
            in.left = new InnerNode(2);
            in.right = new InnerNode(3);
            in.left.left = new InnerNode(4);
            in.left.right = new InnerNode(5);

            in.right.left = new InnerNode(6);
            in.right.right = new InnerNode(7);

            return in;
        }
    }
}
