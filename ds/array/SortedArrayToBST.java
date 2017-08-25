package ds.array;

import ds.tree.Node;

/**
 * Created by sarkarri on 8/3/17.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5};
        Node bstRoot = convertToBST(ar);
        inorderPrint(bstRoot);
    }

    static void inorderPrint(Node root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data+" ");
            inorderPrint(root.right);
        }
    }

    static Node convertToBST(int[] ar) {
        if (ar == null || ar.length == 0)
            return null;
        return convertToBSTUtil(ar, 0, ar.length - 1);
    }

    static Node convertToBSTUtil(int ar[], int l, int r) {
        if (l > r) {
            return null;
        }
        Node root = new Node();
        if (l == r) {
            root.data = ar[l];
        } else {
            int mid = l + (r - l) / 2;
            root.data = ar[mid];
            root.left = convertToBSTUtil(ar, l, mid - 1);
            root.right = convertToBSTUtil(ar, mid + 1, r);
        }

        return root;
    }
}
