package ds.linkedlist;

/**
 * Created by sarkarri on 1/27/17.
 */
public class ArbitPtrGreatestRight {
    public static void main(String[] args) {
        ArbitNode head = new ArbitNode(5);
        head.next = new ArbitNode(10);
        head.next.next = new ArbitNode(2);
        head.next.next.next = new ArbitNode(3);
        ArbitNode res = ptrToGreaterRight(head);

        print(res);
    }

    static ArbitNode ptrToGreaterRight(ArbitNode head) {
        ArbitNode revHead = reverse(head);
        ArbitNode cur = revHead;
        ArbitNode max = revHead;
        while (cur != null && cur.next != null) {
            if (cur.data > cur.next.data) {
                cur.next.arbit = cur;
            } else if (cur.next.data < max.data) {
                cur.next.arbit = max;
            } else {
                max = cur.next;
            }

            cur = cur.next;
        }

        // printArray(revHead);

        head = reverse(revHead);
        return head;
    }


    static ArbitNode reverse(ArbitNode head) {
        ArbitNode next, previous = null;
        ArbitNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        head = previous;
        return head;
    }

    static class ArbitNode {
        int data;
        ArbitNode next, arbit;

        ArbitNode(int data) {
            this.data = data;
        }
    }

    static void print(ArbitNode res) {
        while (res != null) {
            System.out.println(res.data + " arbit " + (res.arbit != null ? res.arbit.data : 0));
            res = res.next;
        }
        System.out.println();
    }
}
