package ds.tree.bst;

import ds.tree.Node;

import java.util.Arrays;

/**
 * Created by sarkarri on 12/28/16.
 */
public class BTreeToBST {
    static int index = 0;

    public static void main(String[] args) {
        int ar[] = inorder(Node.nodeBuilder(), new int[15]);
        Arrays.sort(ar);
        System.out.println();
//        for (int i : ar) {
//            System.out.printf(i + " ");
//        }
        System.out.println("");
        index = 0;
        Node root = transformBST(Node.nodeBuilder(), ar);
        System.out.println();
        inorderPrint(root);

    }

    static int[] inorder(Node root, int[] ar) {
        if (root != null) {
            inorder(root.left, ar);
            ar[index++] = root.data;
            System.out.printf(root.data + " ");
            inorder(root.right, ar);
        }

        return ar;
    }

    static Node transformBST(Node root, int[] ar) {
        if (root != null) {
            transformBST(root.left, ar);
            root.data = ar[index++];
            transformBST(root.right, ar);
        }

        return root;
    }

    static void inorderPrint(Node root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.printf(root.data + " ");
            inorderPrint(root.right);
        }

    }
}
