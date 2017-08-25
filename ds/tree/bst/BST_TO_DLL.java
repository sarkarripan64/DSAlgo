package ds.tree.bst;

import ds.tree.Node;

/**
 * Created by sarkarri on 8/2/17.
 */
public class BST_TO_DLL {
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
        bst.buildSearchTree(bst.root, 51);
        bst.buildSearchTree(bst.root, 61);
        bst.buildSearchTree(bst.root, 53);

        bst.display(bst.root);

        Node head = bst_to_dll(bst.root);
        System.out.println();
        System.out.println("doubly Linked List");
        printDoublyLinkedList(head);
    }

    static Node bst_to_dll(Node root) {
        if (root == null)
            return null;

        //Node head = bst_to_dll_util_way1(root);
//        Node head = bst_to_dll_util_way2(root);
        Node head = bst_to_dll_util_way3(root);
        while (head.left != null)
            head = head.left;

        return head;
    }

    static Node bst_to_dll_util_way1(Node root) {
        if (root == null)
            return null;

        if (root.left != null) {
            Node left = bst_to_dll_util_way1(root.left);

            while (left.right != null) {
                left = left.right;
            }

            left.right = root;
            root.left = left;
        }

        if (root.right != null) {
            Node right = bst_to_dll_util_way1(root.right);
            while (right.left != null)
                right = right.left;

            right.left = root;
            root.right = right;

        }

        return root;
    }

    static Node previous = null;

    static Node bst_to_dll_util_way2(Node root) {
        if (root == null)
            return null;

        Node left = bst_to_dll_util_way2(root.left);
        root.left = previous;
        if (previous != null)
            previous.right = root;
        previous = root;
        bst_to_dll_util_way2(root.right);
        return root;
    }

    static Node head = null;

    static Node bst_to_dll_util_way3(Node root) {
        if (root == null)
            return null;

        bst_to_dll_util_way3(root.right);
        if (head == null) {
            head = root;
        } else {
            //Node temp = head;
            head.left = root;
            root.right = head;
            head = root;
        }
        bst_to_dll_util_way3(root.left);

        return root;
    }

    public static void printDoublyLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }
}
