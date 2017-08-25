package ds.tree;

/**
 * Created by sarkarri on 12/12/16.
 */
public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        BoundaryTraversal bt = new BoundaryTraversal();
        bt.boundaryTraversal(root);
    }

    void boundaryTraversal(Node root) {
        printLeftNodes(root);
        System.out.println("left done");
        printLeafNodes(root);
        System.out.println("leaf done");
        printRightNodes(root);
    }

    void printLeftNodes(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        System.out.printf(root.data + " ");

        if (root.left != null) {
            printLeftNodes(root.left);
        } else {
            printLeftNodes(root.right);
        }
    }

    void printLeafNodes(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.printf(root.data + " ");
            return;
        }

        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    void printRightNodes(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        if (root.right != null) {
            printRightNodes(root.right);
        } else {
            printRightNodes(root.left);
        }

        System.out.printf(root.data + " ");
    }
}
