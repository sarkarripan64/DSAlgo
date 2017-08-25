package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class LinkedUtil {
    static LinkedNode createLinkedList() {
        LinkedNode node = new LinkedNode(1);
        node.next = new LinkedNode(2);
        node.next.next = new LinkedNode(3);
        node.next.next.next = new LinkedNode(4);
        node.next.next.next.next = new LinkedNode(5);
        node.next.next.next.next.next = new LinkedNode(6);
        node.next.next.next.next.next.next = new LinkedNode(7);
        node.next.next.next.next.next.next.next = new LinkedNode(8);
        node.next.next.next.next.next.next.next.next = new LinkedNode(9);
        node.next.next.next.next.next.next.next.next.next = new LinkedNode(10);
        node.next.next.next.next.next.next.next.next.next.next = new LinkedNode(11);
        //node.next.next.next.next.next.next.next.next.next.next.next = new LinkedNode(12);
        //node.next.next.next.next.next.next.next.next.next.next.next = node;
        return node;
    }


    public static void printLinkedList(LinkedNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printCircularLinkedList(LinkedNode head) {
        LinkedNode current = head;
        while (current.next != head) {
            System.out.printf(current.data + " ");
            current = current.next;
        }
        System.out.printf(current.data+ " ");
    }

    public static DoubleLinkedNode createDoublyLinkedList() {
        DoubleLinkedNode node = new DoubleLinkedNode(3);
        node.next = new DoubleLinkedNode(2);
        node.next.next = new DoubleLinkedNode(1);
        node.next.previous = node;
        node.next.next.previous = node.next;
        node.next.next.next = new DoubleLinkedNode(7);
        node.next.next.next.previous = node.next.next;
        node.next.next.next.next = new DoubleLinkedNode(7);
        node.next.next.next.next.previous = node.next.next.next;

        return node;
    }

    public static void printDoublyLinkedList(DoubleLinkedNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
