package ds.tree;

/**
 * Created by sarkarri on 12/27/16.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        printInorder(arrayToBSTConverter(arr, 0, arr.length - 1));
        //arrayToBSTConverter(arr, 0, arr.length - 1);
    }

    static Node arrayToBSTConverter(int ar[], int start, int end) {
        if (start > end)
            return null;
        int mid = (end + start) / 2;
        Node root = new Node(ar[mid]);
        root.left = arrayToBSTConverter(ar, start, mid - 1);
        root.right = arrayToBSTConverter(ar, mid + 1, end);
        return root;
    }

    static void printInorder(Node root) {
        while (root != null) {
            printInorder(root.left);
            System.out.println(root.data + " ");
            printInorder(root.right);
        }
    }
}
