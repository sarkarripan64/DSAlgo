package ds.linkedlist;

/**
 * Created by sarkarri on 1/25/17.
 */
public class RemoveMiddleOfLineSegment {
    CoordinateNode head;

    public static void main(String[] args) {
        RemoveMiddleOfLineSegment llist = new RemoveMiddleOfLineSegment();
        llist.push(40, 5);
        llist.push(20, 5);
        llist.push(7, 5);
        llist.push(7, 10);
        llist.push(5, 10);
        llist.push(1, 10);
        llist.push(0, 10);

        System.out.println("Given list");
        llist.printList(llist.head);

        if (llist.deleteMiddle(llist.head) != null) {
            System.out.println("Modified Linked List is");
            llist.printList(llist.head);
        }


    }

    CoordinateNode deleteMiddle(CoordinateNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        CoordinateNode next = head.next;
        CoordinateNode nextToNext = head.next.next;
        if (head.x == next.x) {
            while (next != null && nextToNext != null && next.x == nextToNext.x) {
                head.next = nextToNext;
                next.next = null;
                next = nextToNext;
                nextToNext = next.next;
            }
        } else if (head.y == next.y) {
            while (next != null && nextToNext != null && next.y == nextToNext.y) {
                head.next = nextToNext;
                next.next = null;
                next = nextToNext;
                nextToNext = next.next;
            }
        }


        //CoordinateNode temp = head;
        deleteMiddle(head.next);
        //head = temp;
        return head;
    }

    static class CoordinateNode {
        int x, y;
        CoordinateNode next;

        CoordinateNode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void push(int x, int y) {
        /* 1 & 2: Allocate the CoordinateNode &
                  Put in the data*/
        CoordinateNode new_node = new CoordinateNode(x, y);
 
        /* 3. Make next of new CoordinateNode as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new CoordinateNode */
        head = new_node;
    }

    void printList(CoordinateNode head) {
        CoordinateNode temp = head;
        while (temp != null) {
            System.out.print("(" + temp.x + "," + temp.y + ")->");
            temp = temp.next;
        }
        System.out.println();
    }

}
