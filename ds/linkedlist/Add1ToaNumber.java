package ds.linkedlist;

/**
 * Created by sarkarri on 1/27/17.
 */
public class Add1ToaNumber {
    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        LinkedNode res = add(head);
        LinkedUtil.printLinkedList(res);
    }

    static LinkedNode add(LinkedNode head) {
        LinkedNode revHead = reverse(head);
        LinkedNode cur = revHead;
        int c = 1, sum = 0;
        LinkedNode temp = null;
        while (cur != null) {
            sum = cur.data + c;
            c = sum / 10;
            sum = sum % 10;
            cur.data = sum;
            temp = cur;
            cur = cur.next;
        }
        if (c > 0) {
            temp.next = new LinkedNode(c);
        }

        head = reverse(revHead);

        return head;
    }

    static LinkedNode reverse(LinkedNode head) {
        LinkedNode next, previous = null;
        LinkedNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        head = previous;
        return head;
    }
}
