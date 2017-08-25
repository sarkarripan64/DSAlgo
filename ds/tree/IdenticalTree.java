package ds.tree;

/**
 * Created by sarkarri on 4/13/17.
 */
public class IdenticalTree {
    public static void main(String[] args) {
        Node root1 = Node.nodeBuilder();
        Node root2 = nodeBuilder1();

        System.out.println(isIdentical(root1, root2));
        System.out.println(isIdentical(root1, nodeBuilder2()));
    }

    static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null) {
            if (root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right))
                return true;
        }
        return false;
    }


    static Node nodeBuilder1() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        return root;
    }

    static Node nodeBuilder2() {
        return Node.nodeBuilder();
    }

}
