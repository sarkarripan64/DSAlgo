package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class Merge2SortedLinkedLsit {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        //LinkedUtil.printLinkedList(head);

        LinkedNode node = new LinkedNode(2);
        node.next = new LinkedNode(3);
        node.next.next = new LinkedNode(11);
        node.next.next.next = new LinkedNode(20);

        //mergeIterative(head, node);

        LinkedNode res = mergeRecursive(head, node);
        System.out.println();
        LinkedUtil.printLinkedList(res);

    }

    static void mergeIterative(LinkedNode a, LinkedNode b) {
        LinkedNode head = null;
        LinkedNode tail = null;
        if (a.data > b.data) {
            head = b;
            b = b.next;
        } else {
            head = a;
            a = a.next;
        }

        tail = head;


        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        while (a != null) {
            tail.next = a;
            a = a.next;
            tail = tail.next;
        }

        while (b != null) {
            tail.next = b;
            b = b.next;
            tail = tail.next;
        }

        LinkedUtil.printLinkedList(head);
    }

    static LinkedNode mergeRecursive(LinkedNode l, LinkedNode r) {
        if (l == null)
            return r;

        if (r == null)
            return l;

        LinkedNode result = null;
        if (l.data < r.data) {
            result = l;
            result.next = mergeRecursive(l.next, r);
        } else {
            result = r;
            result.next = mergeRecursive(l, r.next);
        }

        return result;
    }
}
