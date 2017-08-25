package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by sarkarri on 12/8/16.
 */
public class ZigzagTraversal {
    Node root;

    public static void main(String[] args) {
        ZigzagTraversal zz = new ZigzagTraversal();
        zz.root = Node.nodeBuilder();

        int depth = zz.recursiveDepth(zz.root);
        System.out.println("recursiveDepth " + depth);
        System.out.println("iterativeDepth " + zz.iterativeDepth(zz.root));
        System.out.println();
        zz.spiral(zz.root);
        System.out.println();
        zz.levelOrderTraversal(zz.root);
        System.out.println();
        System.out.println("reverse ");
        zz.reverseLevelOrderTraversal(zz.root);
    }

    public void spiral(Node root) {
        int depth = this.recursiveDepth(root);

        Stack<Node> evenS = new Stack<>();
        Stack<Node> oddS = new Stack<>();
        oddS.push(root);
        while (!evenS.isEmpty() || !oddS.isEmpty()) {
            while (!oddS.isEmpty()) {
                Node top = oddS.pop();
                System.out.print(top.data + " ");
                if (top.left != null)
                    evenS.push(top.left);
                if (top.right != null)
                    evenS.push(top.right);
            }

            while (!evenS.isEmpty()) {
                Node top = evenS.pop();
                System.out.printf(top.data + " ");

                if (top.right != null)
                    oddS.push(top.right);
                if (top.left != null)
                    oddS.push(top.left);
            }
        }
    }

    private int recursiveDepth(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(recursiveDepth(root.left), recursiveDepth(root.right));
    }

    private int iterativeDepth(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int height = 0;
        int nodePerLevel = 0;
        while (true) {
            nodePerLevel = q.size();
            if (nodePerLevel == 0)
                return height;
            height++;

            while (nodePerLevel > 0) {
                Node temp = q.poll();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                nodePerLevel--;
            }
        }
    }

    public void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedBlockingDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.printf(temp.data + " ");
            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }
    }

    public void reverseLevelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            s.push(temp);

            if (temp.right != null)
                q.add(temp.right);

            if (temp.left != null)
                q.add(temp.left);

        }

        while (!s.isEmpty()) {
            System.out.printf(s.pop().data + " ");
        }
    }

}
