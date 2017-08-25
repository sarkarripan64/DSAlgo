package ds.tree;

/**
 * Created by sarkarri on 12/7/16.
 */
public class Node {

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public int data;
    public Node left;
    public Node right;

    public static Node nodeBuilder() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);

        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);


        return root;
    }

    public static void print(Node root) {

    }

}
