package ds.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by sarkarri on 4/4/17.
 */
public class StackUsingQueue<T> {
    Queue<T> queue;
    Queue<T> temp;

    StackUsingQueue() {
        this.queue = new LinkedList<T>();
        this.temp = new LinkedList<T>();
    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        for (int i = 0; i < 10; i++) {
            stackUsingQueue.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stackUsingQueue.pop());
        }
    }

    public void push(T t) {
        temp.add(t);
        while (!queue.isEmpty()) {
            temp.add(queue.poll());
        }
        Queue<T> q = temp;
        temp = queue;
        queue = q;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("empty");

        return queue.poll();
    }

    private boolean isEmpty() {
        return queue.isEmpty() && temp.isEmpty();
    }


}
