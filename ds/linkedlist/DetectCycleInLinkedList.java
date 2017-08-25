package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class DetectCycleInLinkedList {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        //LinkedUtil.printLinkedList(head);
        System.out.println();
        System.out.println(detectCycle(head));
    }

    static boolean detectCycle(LinkedNode head) {

        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
