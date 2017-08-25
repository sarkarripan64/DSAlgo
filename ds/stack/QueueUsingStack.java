package ds.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by sarkarri on 4/4/17.
 */
public class QueueUsingStack<Item> {

    java.util.Stack<Item> stack;
    java.util.Stack<Item> temp;

    public QueueUsingStack() {
        this.stack = new Stack<Item>();
        this.temp = new Stack<Item>();

    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        for (int i = 0; i < 10; i++) {
            queueUsingStack.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queueUsingStack.dequeue());
        }
    }


    public void enqueue(Item item) {
        stack.push(item);
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        if (temp.isEmpty()) {
            populateTemp();
        }

        return temp.pop();
    }

    private void populateTemp() {
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty() && temp.isEmpty();
    }

}
