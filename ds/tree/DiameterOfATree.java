package ds.tree;

/**
 * Created by sarkarri on 4/18/17.
 */
public class DiameterOfATree {
    public static void main(String[] args) {
        Node root = Node.nodeBuilder();
        System.out.println(findDiameter(root));
    }

    static int findDiameter(Node root) {
        if (root == null)
            return 0;

        int lHight = height(root.left);
        int rHight = height(root.right);

        int lDiameter = findDiameter(root.left);
        int rDiameter = findDiameter(root.right);

        return Math.max((lHight + rHight + 1), Math.max(lDiameter, rDiameter));
    }

    static int height(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
