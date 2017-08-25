package ds.tree;

/**
 * Created by sarkarri on 4/13/17.
 */
public class PrintAllRootToLeaf {
    public static void main(String[] args) {
        int path[] = new int[1000];
        Node root = Node.nodeBuilder();
        printAllLeafPaths(root, path, 0);
    }

    static void printAllLeafPaths(Node root, int[] path, int length) {
        if (root == null)
            return;
        path[length] = root.data;
        length++;
        if (root.left == null && root.right == null) {
            print(path, length);
        } else {
            printAllLeafPaths(root.left, path, length);
            printAllLeafPaths(root.right, path, length);
        }
    }

    private static void print(int[] path, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

}
