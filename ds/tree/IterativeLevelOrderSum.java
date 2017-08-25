package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sarkarri on 7/25/17.
 */
public class IterativeLevelOrderSum {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        iterativeLevelOrderTraversal(root);
    }

    static void iterativeLevelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        int sum = 0;
        int level = 0;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {
                level++;
                System.out.println("level " + level + " sum " + sum);
                if (!q.isEmpty()) {
                    q.add(null);
                    sum = 0;
                }
            } else {
                sum = sum + temp.data;
                if (temp.left != null) {
                    q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                }
            }
        }

    }
}
