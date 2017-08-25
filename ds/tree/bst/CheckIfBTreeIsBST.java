package ds.tree.bst;

import ds.tree.Node;

/**
 * Created by sarkarri on 8/4/17.
 */
public class CheckIfBTreeIsBST {
    static int prev = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.getBST();
        bst.display(bst.root);
        System.out.println();
        Node bTreeRoot = Node.nodeBuilder();
        System.out.println("isBST " + isBST(bst.root));
        prev = Integer.MIN_VALUE;
        System.out.println("btree " + isBST(bTreeRoot));
        prev = Integer.MIN_VALUE;
        Node br = build();
        display(br);
        System.out.println();
        System.out.println("br is bst "+isBST(br));
    }

    public static void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    static Node build() {
        Node root = new Node(50);

        root.left = new Node(45);
        root.right = new Node(55);

        root.left.left = new Node(43);
        root.left.right = new Node(47);

        root.right.left = new Node(53);
        root.right.right = new Node(57);

        root.left.left.left = new Node(42);
        root.left.left.right = new Node(44);

        root.left.right.left = new Node(46);
        root.left.right.right = new Node(48);

        root.right.left.left = new Node(52);
        root.right.left.right = new Node(54);

        root.right.right.left = new Node(56);
        root.right.right.right = new Node(58);

        return root;
    }

    static boolean isBST(Node root) {
        if (root == null)
            return true;
        if (!isBST(root.left))
            return false;
        if (root.data < prev)
            return false;
        prev = root.data;
        if (!isBST(root.right))
            return false;

        return true;
    }

}
