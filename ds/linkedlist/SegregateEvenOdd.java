package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class SegregateEvenOdd {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(17);
        llist.push(15);
        llist.push(8);
        llist.push(12);
        llist.push(10);
        llist.push(5);
        llist.push(4);
        llist.push(1);
        llist.push(7);
        llist.push(6);
        LinkedUtil.printLinkedList(llist.head);
        System.out.println();
        segregateEvenOddByTempLL(llist.head);
    }

    static void segregateEvenOdd(LinkedNode head) {
        LinkedNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        LinkedNode current = head;
        LinkedNode end = tail;

        while (current != end) {
            if (current.data % 2 != 0) {
                tail.next = current;
                tail = tail.next;
            }
        }
    }

    static void segregateEvenOddByTempLL(LinkedNode head) {
        LinkedNode even = null;
        LinkedNode even_head = null;
        LinkedNode odd = null;
        LinkedNode odd_head = null;
        LinkedNode current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                if (even == null) {
                    even = current;
                    even_head = even;
                } else {
                    even.next = current;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    odd = current;
                    odd_head = odd;
                } else {
                    odd.next = current;
                    odd = odd.next;
                }
            }
            current = current.next;
        }

        even.next = odd_head;

        LinkedUtil.printLinkedList(even_head);
    }
}
