package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class LastElementToFront {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        LinkedNode secLast = null;
        LinkedNode current = head;
        System.out.println();
        while (current.next != null) {
            secLast = current;
            current = current.next;
        }

        secLast.next = null;
        current.next = head;
        head = current;

        LinkedUtil.printLinkedList(head);
    }
}
