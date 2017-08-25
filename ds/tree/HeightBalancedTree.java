package ds.tree;

/**
 * Created by sarkarri on 4/18/17.
 */
public class HeightBalancedTree {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        System.out.println(isHeightBalanced(root));
    }

    static boolean isHeightBalanced(Node root) {
        if (root == null)
            return true;
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (Math.abs((lHeight - rHeight)) > 1 || !isHeightBalanced(root.left) || !isHeightBalanced(root.right)) {
            return false;
        }

        return true;

    }

    static int height(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
