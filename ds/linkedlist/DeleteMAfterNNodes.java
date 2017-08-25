package ds.linkedlist;

/**
 * Created by sarkarri on 1/20/17.
 */
public class DeleteMAfterNNodes {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        skipMDeleteN(head, 3, 2);
        LinkedUtil.printLinkedList(head);
    }

    static void skipMDeleteN(LinkedNode head, int m, int n) {
        LinkedNode current = head;
        LinkedNode temp = null;
        int skipped = 0, deleted = 0;
        while (current != null) {
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }

            if (current == null || current.next == null)
                return;
            //temp = current;
            for (int j = 0; j < n && current.next != null; j++) {
                current.next = current.next.next;
            }

            current = current.next;
        }
    }

}
