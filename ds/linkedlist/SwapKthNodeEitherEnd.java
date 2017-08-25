package ds.linkedlist;

/**
 * Created by sarkarri on 1/17/17.
 */
public class SwapKthNodeEitherEnd {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        swap(head, 6);
        System.out.println();
        LinkedUtil.printLinkedList(head);
    }

    static void swap(LinkedNode head, int k) {
        LinkedNode ptr = head;
        int c = 0;
        while (ptr != null) {
            c++;
            ptr = ptr.next;
        }

        if (k > c || ((2 * k - 1) == c))
            return;

        LinkedNode beg = head;
        LinkedNode beg_pre = null;
        LinkedNode end = head;
        LinkedNode end_prev = head;

        int i = 1;
        while (i < k && beg != null) {
            i++;
            beg_pre = beg;
            beg = beg.next;
        }

        System.out.println("beg da " + beg.data);

        i = 1;
        while (i < c - k + 1 && end != null) {
            i++;
            end_prev = end;
            end = end.next;
        }

        System.out.println("end da " + end.data);

        int temp = beg.data;
        beg.data = end.data;
        end.data = temp;

    }
}
