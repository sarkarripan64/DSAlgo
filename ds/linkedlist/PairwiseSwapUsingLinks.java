package ds.linkedlist;

/**
 * Created by sarkarri on 1/24/17.
 */
public class PairwiseSwapUsingLinks {
    public static void main(String[] args) {
        pairwiseSwap(LinkedUtil.createLinkedList());
        LinkedUtil.printLinkedList(pairwiseSwapRecursive(LinkedUtil.createLinkedList()));
    }

    static void pairwiseSwap(LinkedNode head) {
        LinkedNode prev = head;
        LinkedNode cur = head.next;

        head = cur;

        while (true) {
            LinkedNode temp = cur.next;
            cur.next = prev;

            if (temp == null || temp.next == null) {
                prev.next = temp;
                break;
            }

            prev.next = temp.next;
            prev = temp;
            cur = prev.next;
        }

        LinkedUtil.printLinkedList(head);
    }

    static LinkedNode pairwiseSwapRecursive(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedNode newHead = head.next;
        LinkedNode remaining = head.next.next;

        head.next.next = head;
        head.next = pairwiseSwapRecursive(remaining);

        return newHead;
    }
}
