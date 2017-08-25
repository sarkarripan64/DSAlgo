package ds.linkedlist;

/**
 * Created by sarkarri on 1/27/17.
 */
public class RearrangeLinkedList {
    public static void main(String[] args) {
        LinkedUtil.printLinkedList(LinkedUtil.createLinkedList());
        rearrange(LinkedUtil.createLinkedList());
    }

    static void rearrange(LinkedNode head) {
        LinkedNode node2 = split(head);
        LinkedNode node = new LinkedNode(0);
        node2 = reverse(node2);
        LinkedNode node1 = head;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                node.next = node1;
                node = node.next;
                node1 = node1.next;
            }

            if (node2 != null) {
                node.next = node2;
                node = node.next;
                node2 = node2.next;
            }
        }

        LinkedUtil.printLinkedList(head);

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

}
