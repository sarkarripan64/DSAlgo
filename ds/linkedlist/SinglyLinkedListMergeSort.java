package ds.linkedlist;

/**
 * Created by sarkarri on 1/27/17.
 */
public class SinglyLinkedListMergeSort {
    public static void main(String[] args) {
        LinkedUtil.printLinkedList(LinkedUtil.createLinkedList());
        LinkedUtil.printLinkedList(mergeSort(LinkedUtil.createLinkedList()));
    }

    static LinkedNode mergeSort(LinkedNode head) {
        if (head == null || head.next == null)
            return head;
        LinkedNode sec = split(head);

        head = mergeSort(head);
        sec = mergeSort(sec);
        return merge(head, sec);
    }

    static LinkedNode split(LinkedNode head) {
        LinkedNode slow = head;
        LinkedNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    static LinkedNode merge(LinkedNode first, LinkedNode second) {
        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }
}
