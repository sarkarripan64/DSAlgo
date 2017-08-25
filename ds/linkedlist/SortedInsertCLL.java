package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class SortedInsertCLL {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printCircularLinkedList(head);
        System.out.println();
        insert(head, 11);

    }

    static void insert(LinkedNode head, int data) {
        LinkedNode current = head;
        LinkedNode tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }

        LinkedNode nn = new LinkedNode(data);
        if (data < head.data) {
            nn.next = head;
            head = nn;
            tail.next = head;
        } else if (data > tail.data) {
            tail.next = nn;
            nn.next = head;
        } else {
            while (current.next != head) {
                if (data > current.next.data) {
                    current = current.next;
                } else {
                    nn.next = current.next;
                    current.next = nn;
                    break;
                }
            }
        }

        LinkedUtil.printCircularLinkedList(head);
    }
}
