package threads;

import java.util.Queue;

/**
 * Created by sarkarri on 5/24/17.
 */
public class BlockingQueue<E> {

    // implement code here ...
    private Queue<E> queue;
    private static final int CAPACITY = 10;

    /**
     * @param queue The underlying "wrapped" queue.
     */
    public BlockingQueue(Queue<E> queue) {
        // implement code here ...
        this.queue = queue;
    }

    /**
     * Inserts the specified element into the underlying queue, waiting if
     * necessary for the underlying queue to be ready to accept new elements.
     *
     * @param e the element to insert.
     */
    public void push(E e) {
        // implement code here ...
        if (e == null)
            throw new NullPointerException();
        synchronized (queue) {
            while (queue.size() == CAPACITY) {
                try {
                    wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            queue.add(e);
            notifyAll();
        }
    }

    /**
     * Retrieves and removes the head of the underlying queue, waiting if
     * necessary until it is capable of providing an element.
     *
     * @return the retrieved element
     */
    public E pull() {
        // implement code here ...
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
            notifyAll();
            return queue.poll();
        }
    }
}
