package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class DeletgeInterMediateNode {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        deleteNode(head, new LinkedNode(10));
        System.out.println();
        LinkedUtil.printLinkedList(head);
    }

    static void deleteNode(LinkedNode head, LinkedNode node2BeDeleted) {
        while (head != null) {
            if (head.data == node2BeDeleted.data) {
                if (head.next != null) {
                    LinkedNode temp = head.next;
                    head.data = temp.data;
                    head.next = temp.next;
                    temp = null;
                    break;
                } else {
                    head = null;
                    break;
                }
            }
            head = head.next;
        }
    }
}
