package ds.tree;

/**
 * Created by sarkarri on 6/2/17.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        int d = getHeight(root);
        for (int i = 1; i <= d; i++) {
            traverseLevelOrder(root, i);
            System.out.println();
        }
    }

    static void traverseLevelOrder(Node root, int depth) {
        if (root == null)
            return;

        if (depth == 1) {
            System.out.print(root.data + " ");
        }

        traverseLevelOrder(root.left, depth - 1);
        traverseLevelOrder(root.right, depth - 1);
    }

    static int getHeight(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
