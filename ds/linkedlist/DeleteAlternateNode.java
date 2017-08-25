package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class DeleteAlternateNode {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        deleteAltNode(head);
    }

    static void deleteAltNode(LinkedNode head) {
        LinkedNode current = head;
        LinkedNode previous = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count % 2 == 0) {
                previous.next = current.next;
            }
            previous = current;
            current = current.next;
        }

        System.out.println();
        LinkedUtil.printLinkedList(head);
    }
}
