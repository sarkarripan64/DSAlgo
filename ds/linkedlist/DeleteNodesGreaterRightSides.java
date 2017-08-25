package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class DeleteNodesGreaterRightSides {
    public static void main(String[] args) {
        //LinkedUtil.printLinkedList(reverse(LinkedUtil.createLinkedList()));
        LinkedList llist = new LinkedList();
        llist.push(3);
        llist.push(2);
        llist.push(6);
        llist.push(5);
        llist.push(11);
        llist.push(10);
        llist.push(15);
        LinkedNode head = llist.push(12);
        LinkedUtil.printLinkedList(head);
        System.out.println();
        deleteGreaterRight(head);
    }

    static void deleteGreaterRight(LinkedNode head) {
        LinkedNode revHead = reverse(head);
        //LinkedUtil.printLinkedList(revHead);
        LinkedNode current = revHead;
        LinkedNode temp = null;
        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                temp = current.next;
                current.next = temp.next;
                temp = null;
            } else {
                current = current.next;
            }
        }

        System.out.println();
        LinkedUtil.printLinkedList(revHead);

        LinkedUtil.printLinkedList(reverse(revHead));
    }

    static LinkedNode reverse(LinkedNode head) {
        LinkedNode current = head;
        LinkedNode next = null;
        LinkedNode previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
        System.out.println();
        return head;
    }
}
