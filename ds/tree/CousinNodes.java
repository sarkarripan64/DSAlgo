package ds.tree;

/**
 * Created by sarkarri on 12/19/16.
 */
public class CousinNodes {
    public static void main(String[] args) {
        CousinNodes cn = new CousinNodes();
        System.out.println(cn.isCousin(Node.nodeBuilder(), 13, 3));
        //System.out.println("lev " + cn.getLevel(Node.nodeBuilder(), 8, 1));
        //System.out.println("sib " + cn.isSibling(Node.nodeBuilder(), 8, 10));
    }

    boolean isCousin(Node root, int a, int b) {
        if (root == null)
            return false;

        return (!isSibling(root, a, b) && (getLevel(root, a, 1) == getLevel(root, b, 1)));
    }

    boolean isSibling(Node root, int a, int b) {
        if (root == null)
            return false;

        if (root.left != null && root.right != null)
            if ((root.left.data == a && root.right.data == b) || (root.left.data == b && root.right.data == a))
                return true;

        return isSibling(root.left, a, b) || isSibling(root.right, a, b);
    }

    int getLevel(Node root, int a, int level) {
        if (root == null)
            return 0;

        if (root.data == a)
            return level;

        int result = getLevel(root.left, a, level + 1);
        if (result == 0)
            return getLevel(root.right, a, level + 1);

        return result;
    }
}
