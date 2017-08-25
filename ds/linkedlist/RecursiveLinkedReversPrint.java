package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class RecursiveLinkedReversPrint {
    public static void main(String[] args) {
        printInReverse(LinkedUtil.createLinkedList());
    }

    static void printInReverse(LinkedNode head) {
        if (head == null)
            return;

        printInReverse(head.next);
        System.out.print(head.data + " ");
    }
}
