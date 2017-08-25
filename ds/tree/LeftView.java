package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sarkarri on 6/2/17.
 */
public class LeftView {
    static int max_level = 0;

    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        leftView(root, 1);
        System.out.println();
        leftView1(root);
    }

    static void leftView1(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        System.out.print(root.data + " ");
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                if (!q.isEmpty()) {
                    System.out.print(q.peek().data + " ");
                    q.add(null);
                }
            } else {
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }

    }

    static void leftView(Node root, int level) {
        if (root == null)
            return;

        if (max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }

        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }
}
