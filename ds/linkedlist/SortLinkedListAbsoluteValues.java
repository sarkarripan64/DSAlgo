package ds.linkedlist;

/**
 * Created by sarkarri on 1/27/17.
 */
public class SortLinkedListAbsoluteValues {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        head = rearrange(head);
        LinkedUtil.printLinkedList(head);
    }

    static LinkedNode rearrange(LinkedNode head) {
        LinkedNode cur = head.next;
        LinkedNode prev = head;
        while (cur != null) {
            if (cur.data < prev.data) {
                prev.next = cur.next;
                cur.next = head;
                head = cur;
                cur = prev;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }

}
