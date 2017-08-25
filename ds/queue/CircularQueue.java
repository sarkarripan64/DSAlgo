package ds.queue;

/**
 * Created by sarkarri on 12/7/16.
 */
public class CircularQueue<E> {
    int size;
    int front, rear = 0;
    private E[] qObj;

    CircularQueue(int capacity) {
        size = capacity;
        qObj = (E[]) new Object[size];
    }

    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        //q.enqueue(1);

        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        q.enqueue(6);
//        q.enqueue(7);
//
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
        //System.out.println(q.dequeue());

        //System.out.println(q.dequeue());
    }


    public boolean isFull() {
        System.out.println("rear "+rear);
        return (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(E element) {
        if (isFull()) {
            throw new RuntimeException("full");
        }

        rear = (rear + 1) % size;
        qObj[rear] = element;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }

        front = (front + 1) % size;
        return qObj[front];
    }

}
