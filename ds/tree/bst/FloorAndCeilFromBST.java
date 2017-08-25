package ds.tree.bst;

import ds.tree.Node;

/**
 * Created by sarkarri on 8/10/17.
 */
public class FloorAndCeilFromBST {
    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.getBST();
        bst.display(bst.root);
        System.out.println();
        System.out.println("ceil " + findFloorAndCeil(bst.root, 47, -1));
    }

    static int findFloorAndCeil(Node root, int ceil, int result) {
        if (root == null)
            return result;
        findFloorAndCeil(root.left, ceil, result);
        if (root.data >= ceil && result == -1) {
            result = root.data;
            //return result;
        }
        findFloorAndCeil(root.right, ceil, result);

        return result;
    }
}
