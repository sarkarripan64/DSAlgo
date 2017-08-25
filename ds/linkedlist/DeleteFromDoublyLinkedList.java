package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class DeleteFromDoublyLinkedList {
    public static void main(String[] args) {
        DoubleLinkedNode head = LinkedUtil.createDoublyLinkedList();
        LinkedUtil.printDoublyLinkedList(head);
        System.out.println();
        deleteNode(head,3);
    }

    static void deleteNode(DoubleLinkedNode head, int data) {
        if (head.data == data) {
            head = head.next;
        } else {
            DoubleLinkedNode current = head;
            while (current != null) {
                if (current.next != null && current.next.next == null && current.next.data == data) {
                    current.next.previous = null;
                    current.next = null;
                    break;
                } else if (current.next.data == data) {
                    current.next = current.next.next;
                    current.next.next.previous = current;
                    break;
                }
                current = current.next;

            }
        }

        LinkedUtil.printDoublyLinkedList(head);

    }
}
