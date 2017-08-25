package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class PairwiseSwap {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);

        LinkedNode current = head;
        while (current != null && current.next != null) {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
        System.out.println();
        //head = current;
        LinkedUtil.printLinkedList(head);
    }
}
