package ds.linkedlist;

/**
 * Created by sarkarri on 1/16/17.
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        System.out.println();
        rotate(head, 3);
    }

    static void rotate(LinkedNode head, int k) {
        int i = 0;
        LinkedNode current = head;
        LinkedNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (i < k) {
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = null;
            i++;
        }

        LinkedUtil.printLinkedList(head);
    }

}
