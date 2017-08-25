package ds.linkedlist;


/**
 * Created by sarkarri on 1/17/17.
 */
public class FlattenLinkedList {
    Node head;

     /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

   private class Node {
        Node right, down;
        int data;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    Node push(Node head, int data) {
        Node nn = new Node(data);
        nn.down = head;
        head = nn;
        return head;
    }

    static Node merge(Node l, Node r) {
        if (l == null)
            return r;
        if (r == null)
            return l;

        Node result = null;

        if (l.data < r.data) {
            result = l;
            result.down = merge(l.down, r);
        } else {
            result = r;
            result.down = merge(l, r.down);
        }

        return result;
    }

    static Node flatten(Node root) {
        if (root == null || root.right == null)
            return root;

        root.right = flatten(root.right);

        root = merge(root, root.right);

        return root;
    }


    public static void main(String[] args) {
        FlattenLinkedList L = new FlattenLinkedList();
        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 20);

        // flatten the list
        L.head = L.flatten(L.head);

        printList(L.head);
    }

    static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.down;
        }
    }
}



