package ds.tree.bst;

import ds.tree.Node;

import java.util.ArrayList;

/**
 * Created by sarkarri on 8/10/17.
 */
public class MergeTwoBST {
    public static void main(String[] args) {
        BinarySearchTree bst = BinarySearchTree.getBST();
        Node t1 = bst.root;
        Node t2 = build();
        Node mergedRoot = merge(t1, t2);
        display(mergedRoot);
        boolean isBst = CheckIfBTreeIsBST.isBST(mergedRoot);
        System.out.println();
        System.out.println("isBst " + isBst);
    }

    public static void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    public static Node merge(Node t1, Node t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        list1 = getBSTElementsSorted(t1, list1);
        list2 = getBSTElementsSorted(t2, list2);

        ArrayList<Node> list3 = mergeTwoList(list1, list2);
        return createBSTFromSortedArray(list3, 0, list3.size() - 1);
    }

    private static ArrayList<Node> mergeTwoList(ArrayList<Node> list1, ArrayList<Node> list2) {
        ArrayList<Node> list3 = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).data < list2.get(j).data) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            list3.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            list3.add(list2.get(j));
            j++;
        }

        return list3;
    }

    private static Node createBSTFromSortedArray(ArrayList<Node> list, int l, int r) {
        if (l > r)
            return null;

        int mid = l + (r - l) / 2;
        Node root = new Node();
//        if (l == r) {
//            root.data = list.get(l).data;
//            return root;
//        } else {
            root.data = list.get(mid).data;
            root.left = createBSTFromSortedArray(list, l, mid - 1);
            root.right = createBSTFromSortedArray(list, mid + 1, r);
        //}
        return root;
    }

    private static ArrayList<Node> getBSTElementsSorted(Node root, ArrayList<Node> list) {
        if (root == null)
            return null;

        getBSTElementsSorted(root.left, list);
        list.add(root);
        getBSTElementsSorted(root.right, list);

        return list;
    }


    static Node build() {
        Node root = new Node(50);

        root.left = new Node(45);
        root.right = new Node(55);

        root.left.left = new Node(43);
        root.left.right = new Node(47);

        root.right.left = new Node(53);
        root.right.right = new Node(57);

        root.left.left.left = new Node(42);
        root.left.left.right = new Node(44);

        root.left.right.left = new Node(46);
        root.left.right.right = new Node(48);

        root.right.left.left = new Node(52);
        root.right.left.right = new Node(54);

        root.right.right.left = new Node(56);
        root.right.right.right = new Node(58);

        return root;
    }

}
