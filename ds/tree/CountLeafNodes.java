package ds.tree;

/**
 * Created by sarkarri on 12/14/16.
 */
public class CountLeafNodes {
    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        CountLeafNodes cn = new CountLeafNodes();
        System.out.println("no of leafs " + cn.count(Node.nodeBuilder()));
        System.out.println("max value "+cn.getMAxValue(Node.nodeBuilder()));
    }

    int count(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return count(root.left) + count(root.right);
    }

    int getMAxValue(Node root) {
        if (root == null) {
            return 0;
        }

        if (max < root.data)
            max = root.data;

        getMAxValue(root.left);
        getMAxValue(root.right);

        return max;
    }
}
