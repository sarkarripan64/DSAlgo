package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class ReverseLinkedLsitInGroups {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        System.out.println();
        LinkedUtil.printLinkedList(reverseInGroups(head, 3));

    }

    static LinkedNode reverseInGroups(LinkedNode head, int k) {
        if (head == null)
            return null;

        LinkedNode current = head;
        LinkedNode previous = null;
        LinkedNode temp = null;
        int count = 0;
        while (count < k && current != null) {
            count++;
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        if (current != null)
            head.next = reverseInGroups(current, k);

        return previous;
    }
}
