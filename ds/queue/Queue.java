package ds.queue;

/**
 * Created by sarkarri on 12/2/16.
 */
public interface Queue<E> {

    <E> void enqueue(E element);

    E dequeue();

    int size();

    E peek();

    boolean isEmpty();
}
