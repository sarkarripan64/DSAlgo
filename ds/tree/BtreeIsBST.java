package ds.tree;

import ds.tree.bst.BinarySearchTree;

/**
 * Created by sarkarri on 12/20/16.
 */
public class BtreeIsBST {
    public static void main(String[] args) {
        BtreeIsBST bst = new BtreeIsBST();

        //System.out.println("is bst " + bst.isBST(BinarySearchTree.getBST(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data < min || root.data > max)
            return false;

        return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
    }

}
