package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class NthNode {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        System.out.println();
        nthNode(head, 10);
    }

    static void nthNode(LinkedNode head, int n) {
        int count = 0;
        while (head != null) {
            count++;
            if (count == n) {
                System.out.println(head.data);
                break;
            }
            head = head.next;
        }
    }
}
