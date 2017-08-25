package ds.tree.bst;

/**
 * Created by sarkarri on 12/27/16.
 */
public class BSTArrayToSorted {
    public static void main(String[] args) {
        int ar[] = {4, 2, 5, 1, 3};
        printBST(ar, 0, ar.length);
    }

    public static void printBST(int ar[], int start, int end) {
        if (ar == null)
            return;

        if (start < end) {
            printBST(ar, start * 2 + 1, end);

            System.out.printf(ar[start] + " ");

            printBST(ar, start * 2 + 2, end);
        }
    }
}
