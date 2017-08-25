package ds.linkedlist;

/**
 * Created by sarkarri on 1/14/17.
 */
public class LinkedList {
    LinkedNode head;


    LinkedNode push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        LinkedNode new_node = new LinkedNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;

        return head;
    }
}
