package ds.tree.bst;

import ds.tree.Node;

/**
 * Created by sarkarri on 12/16/16.
 */
public class BinarySearchTree {

    public Node root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.buildSearchTree(bst.root, 50);
        bst.buildSearchTree(bst.root, 45);
        bst.buildSearchTree(bst.root, 47);
        bst.buildSearchTree(bst.root, 55);
        bst.buildSearchTree(bst.root, 54);
        bst.buildSearchTree(bst.root, 43);
        bst.buildSearchTree(bst.root, 48);
        bst.buildSearchTree(bst.root, 49);
        bst.buildSearchTree(bst.root, 60);
        bst.buildSearchTree(bst.root, 46);
        bst.buildSearchTree(bst.root, 44);
        bst.buildSearchTree(bst.root, 42);


        bst.display(bst.root);
        System.out.println();
        System.out.println(" found " + bst.findElementIterative(bst.root, 546));
        bst.display(bst.deleteElement(bst.root, 49));
    }


    Node buildSearchTree(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (data > root.data) {
            root.right = buildSearchTree(root.right, data);
        } else if (data < root.data) {
            root.left = buildSearchTree(root.left, data);
        }

        return root;
    }

    boolean findElementRecursive(Node node, int data) {
        if (node == null)
            return false;
        if (node.data == data)
            return true;
        if (root.left != null)
            return findElementRecursive(node.left, data);

        if (root.right != null)
            return findElementRecursive(root.right, data);

        return false;
    }

    boolean findElementIterative(Node root, int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data)
                return true;

            if (data < current.data)
                current = current.left;
            else
                current = current.right;
        }

        return false;
    }

    Node deleteElement(Node root, int data) {
        if (root == null)
            return null;

        if (data < root.data) {
            root.left = deleteElement(root.left, data);
        } else if (data > root.data) {
            root.right = deleteElement(root.right, data);
        } else if (root.data == data) {
            if (root.left != null && root.right != null) {
                Node tmp = findMaxFromLeft(root.left);
                root.data = tmp.data;
                root.left = deleteElement(root.left, tmp.data);
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                root = null;
            }
        }

        return root;
    }

    int findSmallestFromRight(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    Node findMaxFromLeft(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    public static BinarySearchTree getBST() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.buildSearchTree(bst.root, 50);
        bst.buildSearchTree(bst.root, 45);
        bst.buildSearchTree(bst.root, 47);
        bst.buildSearchTree(bst.root, 55);
        bst.buildSearchTree(bst.root, 54);
        bst.buildSearchTree(bst.root, 43);
        bst.buildSearchTree(bst.root, 48);
        bst.buildSearchTree(bst.root, 49);
        bst.buildSearchTree(bst.root, 60);
        bst.buildSearchTree(bst.root, 46);
        bst.buildSearchTree(bst.root, 42);
        bst.buildSearchTree(bst.root, 44);

        return bst;
    }

}
