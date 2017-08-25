package ds.linkedlist;

/**
 * Created by sarkarri on 1/27/17.
 */
public class RearrangeZigzag {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        zigzag(head);
        LinkedUtil.printLinkedList(head);
    }

    static void zigzag(LinkedNode head) {
        boolean flag = true;
        LinkedNode cur = head;
        while (cur.next != null) {
            if (flag) {
                if (cur.data > cur.next.data) {
                    int temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                }
            } else {
                if (cur.data < cur.next.data) {
                    int temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                }
            }
            flag = !flag;
            cur = cur.next;
        }
    }
}
