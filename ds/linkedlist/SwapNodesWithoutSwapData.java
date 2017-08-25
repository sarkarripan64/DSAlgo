package ds.linkedlist;

/**
 * Created by sarkarri on 1/25/17.
 */
public class SwapNodesWithoutSwapData {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        LinkedUtil.printLinkedList(head);
        LinkedUtil.printLinkedList(swap(head, 10, 12));
    }

    static LinkedNode swap(LinkedNode head, int x, int y) {
        if(x == y){
            return head;
        }
        LinkedNode curX = head;
        LinkedNode prevX = null;
        LinkedNode curY = head;
        LinkedNode prevY = null;
        while (curX != null && curX.data != x) {
            prevX = curX;
            curX = curX.next;
        }

        while (curY != null && curY.data != y) {
            prevY = curY;
            curY = curY.next;
        }

        if (prevX != null) {
            prevX.next = curY;
        } else {
            head = curY;
        }

        if (prevY != null) {
            prevY.next = curX;
        } else {
            head = curX;
        }

        LinkedNode temp = curX.next;
        curX.next = curY.next;
        curY.next = temp;

        return head;
    }
}
