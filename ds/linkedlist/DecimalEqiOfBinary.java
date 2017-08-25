package ds.linkedlist;

/**
 * Created by sarkarri on 1/28/17.
 */
public class DecimalEqiOfBinary {
    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(0);
        head.next.next = new LinkedNode(1);
        head.next.next.next = new LinkedNode(1);
        System.out.println(decimalEqui(head));
        //System.out.println(pow(3));
    }

    static int decimalEqui(LinkedNode head) {
        LinkedNode cur = head;
        while (cur != null && cur.data != 1) {
            cur = cur.next;
        }

        LinkedNode revHead = reverse(cur);
        int dec = revHead.data;
        int p = 1;
        revHead = revHead.next;
        while (revHead != null) {
            dec = dec + pow(p) * revHead.data;
            p++;
            revHead = revHead.next;
        }

        return dec;
    }

    static int pow(int exp) {
        if (exp == 0)
            return 1;
        return 2 * pow(exp - 1);
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

    static int decimalEquiSimpler(LinkedNode head) {
        int dec = 0;
        while (head != null) {
            dec = (dec << 1) + head.data;
            head = head.next;
        }

        return dec;
    }
}
