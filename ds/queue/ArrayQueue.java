package ds.queue;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by sarkarri on 11/30/16.
 */
public class ArrayQueue<E> implements Queue<E> {
    int front = -1;
    int rear = -1;
    final E[] items;

    public static void main(String[] args) {
        java.util.Queue q = new ArrayBlockingQueue(10);
        List<String> list = new ArrayList<String>();
        //q.add()
        list.iterator();
    }

    public ArrayQueue(int capacity) {
        items = (E[]) new Object[capacity];
    }

    public <E> void enque(E element) {

    }

    @Override
    public <E1> void enqueue(E1 element) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E peek() {
        return null;
    }

    public boolean isEmpty() {
        return front == rear || rear == -1;
    }

//    protected boolean isFull(){
//        return
//    }

}
