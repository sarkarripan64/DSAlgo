package ds.linkedlist;

/**
 * Created by sarkarri on 1/24/17.
 */
public class MergeLinkedListAltPosition {
    public static void main(String[] args) {
        LinkedNode l1 = new LinkedNode(1);
        l1.next = new LinkedNode(3);
        l1.next.next = new LinkedNode(5);

        LinkedNode l2 = new LinkedNode(2);
        l2.next = new LinkedNode(4);
        l2.next.next = new LinkedNode(6);

        l2.next.next.next = new LinkedNode(8);
        merge(l1, l2);
    }

    static void merge(LinkedNode head1, LinkedNode head2) {
        LinkedNode ptr1 = head1;
        LinkedNode ptr2 = head2;

        while (ptr1 != null && ptr2 != null) {
            LinkedNode temp = ptr1.next;
            ptr1.next = ptr2;
            ptr2 = ptr2.next;
            ptr1.next.next = temp;
            ptr1 = temp;
        }

        //if (ptr2 != null) {
            head2 = ptr2;
        //}

        LinkedUtil.printLinkedList(head1);
        LinkedUtil.printLinkedList(head2);
    }
}
