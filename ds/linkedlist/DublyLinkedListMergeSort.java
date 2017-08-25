package ds.linkedlist;

/**
 * Created by sarkarri on 1/26/17.
 */
public class DublyLinkedListMergeSort {
    public static void main(String[] args) {
        DoubleLinkedNode head = LinkedUtil.createDoublyLinkedList();
        LinkedUtil.printDoublyLinkedList(head);
        LinkedUtil.printDoublyLinkedList(mergeSort(head));
    }

    static DoubleLinkedNode mergeSort(DoubleLinkedNode head) {
        if (head == null || head.next == null)
            return head;
        DoubleLinkedNode sec = split(head);

        head = mergeSort(head);
        sec = mergeSort(sec);
        return merge(head, sec);
    }

    static DoubleLinkedNode split(DoubleLinkedNode head) {
        DoubleLinkedNode slow = head;
        DoubleLinkedNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        DoubleLinkedNode temp = slow.next;
        slow.next = null;
        return temp;
    }

    static DoubleLinkedNode merge(DoubleLinkedNode first, DoubleLinkedNode second) {
        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.previous = first;
            first.previous = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.previous = second;
            second.previous = null;
            return second;
        }
    }


}
