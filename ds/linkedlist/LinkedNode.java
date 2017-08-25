package ds.linkedlist;

/**
 * Created by sarkarri on 1/13/17.
 */
public class LinkedNode {
    LinkedNode next;
    int data;
    LinkedNode head;


    LinkedNode(int d) {
        data = d;
        next = null;
    }


    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }



}
