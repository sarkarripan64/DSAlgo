package ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarkarri on 1/14/17.
 */
public class LoopDetectionNRemoval {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        //LinkedUtil.printLinkedList(head);
        //detectNRemoveLoop(head);
        detectAndRemoveLoop(head);
        System.out.println();
        LinkedUtil.printLinkedList(head);
    }

    static void detectNRemoveLoop(LinkedNode head) {
        Map<LinkedNode, Integer> map = new HashMap<>();
        LinkedNode current = head;
        LinkedNode previous = null;
        while (current != null) {
            if (!map.containsKey(current)) {
                map.put(current, 1);
                previous = current;
                current = current.next;
            } else {
                previous.next = null;
                break;
            }
        }

        LinkedUtil.printLinkedList(head);
    }

    static void detectAndRemoveLoop(LinkedNode node) {
        LinkedNode slow = node;
        LinkedNode fast = node.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
 
        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
 
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */

        }
    }
}
