package ds.linkedlist;

/**
 * Created by sarkarri on 1/17/17.
 */
public class SortLLOf0s1s2s {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.push(0);
        llist.push(1);
        llist.push(0);
        llist.push(2);
        llist.push(1);
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(2);

        LinkedNode head = sort(llist.head);
        LinkedUtil.printLinkedList(head);

    }

    static LinkedNode sort(LinkedNode head) {
        LinkedNode current = head;
        int count[] = {0, 0, 0};

        while (current != null) {
            count[current.data]++;
            current = current.next;
        }

        int i = 0;
        current = head;
        while (current != null) {
            if (count[i] == 0) {
                i++;
            } else {
                current.data = i;
                count[i]--;
                current = current.next;
            }
        }

        return head;
    }


}
