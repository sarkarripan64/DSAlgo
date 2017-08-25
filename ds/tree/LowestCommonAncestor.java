package ds.tree;

/**
 * Created by sarkarri on 12/16/16.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        System.out.printf("lca of " + lca.findLCA(Node.nodeBuilder(), 8, 2).data);
    }

    Node findLCA(Node root, int a, int b) {
        if (root == null)
            return null;

        if (root.data == a || root.data == b)
            return root;
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
