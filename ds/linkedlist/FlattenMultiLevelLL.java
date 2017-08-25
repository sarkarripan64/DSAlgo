package ds.linkedlist;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by sarkarri on 1/17/17.
 */
public class FlattenMultiLevelLL {
    static Node head;

    class Node {
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

    static Node flattenList(Node head) {
        Node ptr = head;
        Node tail = head;
        while (tail.right != null) {
            tail = tail.right;
        }

        Node tmp = null;
        while (ptr != tail) {
            if (ptr.down != null) {
                tail.right = ptr.down;

                tmp = ptr.down;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
            }

            tail = tmp;

            ptr = ptr.right;
        }
        return head;
    }

    public static void main(String[] args) {
        FlattenMultiLevelLL list = new FlattenMultiLevelLL();
        head = list.createList();
        list.flattenList(head);

        list.printList(head);
    }

    Node createList() {
        int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};

        /* create 8 linked lists */
        Node head1 = createList(arr1, arr1.length);
        Node head2 = createList(arr2, arr2.length);
        Node head3 = createList(arr3, arr3.length);
        Node head4 = createList(arr4, arr4.length);
        Node head5 = createList(arr5, arr5.length);
        Node head6 = createList(arr6, arr6.length);
        Node head7 = createList(arr7, arr7.length);
        Node head8 = createList(arr8, arr8.length);

        /* modify down pointers to create the list shown above */
        head1.down = head2;
        head1.right.right.right.down = head3;
        head3.down = head4;
        head4.down = head5;
        head2.right.down = head6;
        head2.right.right.down = head7;
        head7.down = head8;

        /* Return head pointer of first linked list.  Note that all nodes are
         reachable from head1 */
        return head1;
    }

    Node createList(int arr[], int n) {
        Node node = null;
        Node p = null;

        int i;
        for (i = 0; i < n; ++i) {
            if (node == null) {
                node = p = new Node(arr[i]);
            } else {
                p.right = new Node(arr[i]);
                p = p.right;
            }
            p.right = p.down = null;
        }
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println("");
    }
}
