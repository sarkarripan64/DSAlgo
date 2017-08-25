package ds.tree;

import ds.tree.bst.BinarySearchTree;

/**
 * Created by sarkarri on 12/27/16.
 */
public class PrintWithinRangeBST {
    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.getBST();
        printRange(bst.root, 40, 100);
    }

    static void printRange(Node root, int k1, int k2) {
        if (root != null) {
            if (k2 < root.data) {
                printRange(root.left, k1, k2);
            } else if (k1 > root.data) {
                printRange(root.right, k1, k2);
            } else {
                printRange(root.left, k1, k2);
                System.out.printf(root.data + " ");
                printRange(root.right, k1, k2);
            }
        }
    }
}
