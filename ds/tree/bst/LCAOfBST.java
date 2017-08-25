package ds.tree.bst;

import ds.tree.Node;

/**
 * Created by sarkarri on 4/13/17.
 */
public class LCAOfBST {
    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.getBST();
        System.out.println("LAC " + findLCA(bst.root, 48, 49).data);
    }

    static Node findLCA(Node root, int k1, int k2) {
        if (root == null)
            return null;
        if (root.data > k1 && root.data > k2)
            return findLCA(root.left, k1, k2);
        if (root.data < k1 && root.data < k2)
            return findLCA(root.right, k1, k2);

        return root;

    }
}
