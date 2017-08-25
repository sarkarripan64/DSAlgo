package ds.tree.bst;

import ds.tree.Node;

/**
 * Created by sarkarri on 8/14/17.
 */
public class AVLTree {
    Node root;

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

//        /* Constructing tree given in the above figure */
//        tree.root = tree.insert(tree.root, 10);
//        tree.root = tree.insert(tree.root, 20);
//        tree.root = tree.insert(tree.root, 30);
//        tree.root = tree.insert(tree.root, 40);
//        tree.root = tree.insert(tree.root, 50);
//        tree.root = tree.insert(tree.root, 25);
//
//        /* The constructed AVL Tree would be
//             30
//            /  \
//          20   40
//         /  \     \
//        10  25    50
//        */
//        System.out.println("Pre-order traversal of constructed tree is : ");
//        tree.preOrder(tree.root);
//        System.out.println();
         /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        /* The constructed AVL Tree would be
           9
          /  \
         1    10
        /  \    \
        0    5    11
        /    /  \
        -1   2    6
         */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder(tree.root);

        tree.root = tree.delete(tree.root, 10);

        /* The AVL Tree after deletion of 10
           1
          /  \
         0    9
        /     / \
        -1    5   11
        /  \
        2    6
         */
        System.out.println("");
        System.out.println("Preorder traversal after deletion of 10 :");
        tree.preOrder(tree.root);
    }


    void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        } else {
            //duplicate data
            return root;
        }

        int balance_factor = height(root.left) - height(root.right);

        if (balance_factor > 1) {
            if (data < root.left.data) {
                //LL case
                return rotateRight(root);
            } else {//LR case
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }

        if (balance_factor < -1) {
            //RR case
            if (data > root.right.data) {
                return rotateLeft(root);
            } else {
                //RL case
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }

    Node delete(Node root, int data) {
        if (root == null)
            return null;

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else if (root.data == data) {
            if (root.left != null && root.right != null) {
                Node temp = findInorderSuccessor(root.right);
                root.data = temp.data;
                delete(root.right, temp.data);
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
        }

        int balance_factor = getBalanceFactor(root);

        if (balance_factor > 1) {
            if (getBalanceFactor(root.left) >= 0) {
                return rotateRight(root);
            } else {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }

        if (balance_factor < -1) {
            if (getBalanceFactor(root.right) <= 0) {
                return rotateLeft(root);
            } else {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }

    int getBalanceFactor(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    Node findInorderSuccessor(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    Node rotateRight(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    Node rotateLeft(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }

    int height(Node root) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
