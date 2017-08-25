package ds.tree;

/**
 * Created by sarkarri on 4/13/17.
 */
public class MirrorTree {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        System.out.println("before ");
        ZigzagTraversal tt = new ZigzagTraversal();
        tt.levelOrderTraversal(root);
        System.out.println();
        Node mirror = createMirror(root);
        System.out.println("after ");
        tt.levelOrderTraversal(mirror);
    }

    static Node createMirror(Node root) {
        if (root == null)
            return null;

        Node left = createMirror(root.left);
        Node right = createMirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
