package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class InsertionAtSortedLinkedLsit {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        insertNode(head, 11);
    }

    static void insertNode(LinkedNode head, int data) {
        LinkedNode newNode = new LinkedNode(data);
        if (data < head.data) {
            newNode.next = head;
            head = newNode;
        }

        LinkedNode current = head;


        while (current != null) {
            if (data > current.data && current.next == null) {
                current.next = newNode;
            } else if (data >= current.data && data < current.next.data) {
                newNode.next = current.next;
                current.next = newNode;
                break;
            } else {
                current = current.next;
            }
        }
        System.out.println();
        LinkedUtil.printLinkedList(head);
    }
}
