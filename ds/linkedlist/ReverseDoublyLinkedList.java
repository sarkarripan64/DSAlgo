package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        DoubleLinkedNode head = LinkedUtil.createDoublyLinkedList();
        LinkedUtil.printDoublyLinkedList(head);
        reverse(head);
    }

    static void reverse(DoubleLinkedNode head) {
        DoubleLinkedNode current = head;
        DoubleLinkedNode temp = null;
        while (current.next != null) {
            temp = current.next;
            current.next = current.previous;
            current.previous = temp;
            current = temp;
        }

        current.next = current.previous;
        System.out.println();
        head = current;

        LinkedUtil.printDoublyLinkedList(head);
    }
}
