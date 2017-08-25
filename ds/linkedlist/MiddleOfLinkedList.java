package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        System.out.println();
        //findMiddle(head);
        findMiddle2(head);
    }

    static void findMiddle(LinkedNode head) {
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow.data);
    }

    static void findMiddle2(LinkedNode head) {
        LinkedNode mid = head;
        int count = 0;
        while (head != null) {
            if (count % 2 != 0) {
                mid = mid.next;
            }

            count++;
            head = head.next;
        }

        System.out.println(mid.data);
    }
}
