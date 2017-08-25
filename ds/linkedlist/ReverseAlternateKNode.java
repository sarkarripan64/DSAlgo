package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class ReverseAlternateKNode {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        System.out.println();
        LinkedUtil.printLinkedList(reverseAltKNode(head, 3));
    }

    static LinkedNode reverseAltKNode(LinkedNode head, int k) {
        LinkedNode current = head;
        LinkedNode next = null;
        LinkedNode previous = null;
        int count = 0;
        while (count < k && current != null) {
            count++;
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        count = 0;
        if (current != null) {
            head.next = current;
            while (count < k && current != null) {
                count++;
                head = current;
                current = current.next;
            }
        }
        if (current != null) {
            head.next = reverseAltKNode(current, k);
        }

        return previous;
    }
}
