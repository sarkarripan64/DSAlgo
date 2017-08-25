package ds.tree;

/**
 * Created by sarkarri on 4/13/17.
 */
public class MaxDepthOfTree {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        System.out.println(getMaxDepth(root));
    }

    static int getMaxDepth(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }
}
