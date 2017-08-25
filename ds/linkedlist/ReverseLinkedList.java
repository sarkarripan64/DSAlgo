package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        System.out.println();
        reverse(head);
    }

    static void reverse(LinkedNode head) {
        LinkedNode current = head;
        LinkedNode previous = null;
        LinkedNode temp = null;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        head = previous;
        LinkedUtil.printLinkedList(head);
    }
}
