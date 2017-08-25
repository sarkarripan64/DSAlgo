package ds.linkedlist;

/**
 * Created by sarkarri on 1/28/17.
 */
public class FlattenMultiLevelDepthwise {
    static Node last;

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.down = new Node(7);
        head.next.down.next = new Node(8);

        head.next.down.next.down = new Node(16);
        head.next.down.next.down.down = new Node(17);
        head.next.down.next.down.down.next = new Node(18);
        head.next.down.next.down.down.next.next = new Node(19);
        head.next.down.next.down.down.next.next.next = new Node(20);
        head.next.down.next.down.down.next.next.next.down = new Node(21);


        head.next.down.next.next = new Node(10);
        head.next.down.next.next.next = new Node(12);
        head.next.down.down = new Node(9);
        head.next.down.down.down = new Node(14);
        head.next.down.down.down.down = new Node(15);
        head.next.down.down.down.down.next = new Node(23);
        head.next.down.down.down.down.next.down = new Node(24);

        FlattenMultiLevelDepthwise fl = new FlattenMultiLevelDepthwise();

        fl.print(fl.flatten(head));
    }

    Node flatten(Node head) {
        if (head != null) {

            Node next = head.next;
            last = head;
            if (head.down != null) {
                head.next = flatten(head.down);
            }

            if (next != null) {
                last.next = flatten(next);
            }
        }

        return head;
    }

    void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    static class Node {
        int data;
        Node next;
        Node down;

        Node(int data) {
            this.data = data;
        }
    }
}
