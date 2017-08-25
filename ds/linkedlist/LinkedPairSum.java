package ds.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sarkarri on 1/29/17.
 */
public class LinkedPairSum {
    public static void main(String[] args) {
        LinkedNode head = LinkedUtil.createLinkedList();
        findPair(head, 17);
    }

    static void findPair(LinkedNode head, int k) {
        Map<Integer, Boolean> map = new LinkedHashMap<>();
        LinkedNode cur = head;
        int c = 0;
        while (cur != null) {
            c++;
            map.put(cur.data, true);
            cur = cur.next;
        }

        cur = head;
        int t = 0;
        while (cur != null && t <= c / 2) {
            if (map.containsKey(k - cur.data)) {
                System.out.printf(cur.data + " pairs with " + (k - cur.data));
            }
            System.out.println();
            cur = cur.next;
            t++;
        }
    }
}
