package ds.linkedlist;

import ds.tree.Node;

/**
 * Created by sarkarri on 1/27/17.
 */
public class BTreeToDLL {
    DoubleLinkedNode head;
    DoubleLinkedNode cur;

    public static void main(String[] args) {
        Node bt = Node.nodeBuilder();
        BTreeToDLL btl = new BTreeToDLL();
        btl.creatDLL(bt);
        LinkedUtil.printDoublyLinkedList(btl.head);
    }

    void creatDLL(Node root) {
        if (root != null) {
            creatDLL(root.left);
            if (head == null) {
                head = createNewDLNode(root);
                cur = head;
            } else {
                cur.next = createNewDLNode(root);
                cur.next.previous = cur;
                cur = cur.next;
            }
            creatDLL(root.right);
        }
    }

    DoubleLinkedNode createNewDLNode(Node node) {
        return new DoubleLinkedNode(node.data);
    }
}
