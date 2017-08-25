package ds.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sarkarri on 12/15/16.
 */
public class AllTreePaths {
    public static void main(String[] args) {
        AllTreePaths atp = new AllTreePaths();

        int depth = atp.getDepth(Node.nodeBuilder());
        atp.recursivePaths(Node.nodeBuilder(), new int[depth], 0);

        System.out.println("iterative");
        atp.iterativePath(Node.nodeBuilder());
    }

    void recursivePaths(Node root, int[] pa, int length) {
        if (root == null)
            return;

        pa[length] = root.data;
        length++;

        if (root.left == null && root.right == null) {
            printPath(pa, length);
            return;
        }

        recursivePaths(root.left, pa, length);
        recursivePaths(root.right, pa, length);
    }

    private void printPath(int[] pa, int len) {
        for (int i = 0; i < len; i++)
            System.out.printf(pa[i] + "  ");

        System.out.println();
    }

    int getDepth(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    void iterativePath(Node root) {

        Stack<Node> s = new Stack<>();
        s.push(root);
        Map<Node, Node> map = new HashMap<>();

        while (!s.isEmpty()) {
            Node temp = s.pop();

            if (temp.left == null && temp.right == null) {
                printTopDownPath(temp, map);
            }

            if (temp.right != null) {
                map.put(temp.right, temp);
                s.push(temp.right);
            }

            if (temp.left != null) {
                map.put(temp.left, temp);
                s.push(temp.left);
            }

        }
    }

    void printTopDownPath(Node root, Map<Node, Node> parentMap) {
        Stack<Node> s = new Stack<>();
        while (root != null) {
            s.push(root);
            root = parentMap.get(root);
        }

        while (!s.isEmpty()) {
            System.out.printf(s.pop().data + "  ");
        }
        System.out.println();
    }
}
