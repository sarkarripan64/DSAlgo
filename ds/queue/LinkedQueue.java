package ds.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sarkarri on 12/2/16.
 */
public class LinkedQueue<E> implements Queue<E> {
    private int capacity = 0;
    private Node first;
    private Node last;
    private int size;

    public LinkedQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public <E> void enqueue(E element) {
        if (isEmpty()) {
            first = new Node();
            first.element = element;
            last = first;
        } else {
            Node temp = last;
            last = new Node();
            last.element = element;
            temp.next = last;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("underflow");
        Node temp = first;
        E element = (E) temp.element;
        first = first.next;
        if (isEmpty())
            first = last = null;
        size--;
        return element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("underflow");

        return (E) first.element;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    private class Node<E> {
        E element;
        Node next;

        public Node() {
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    public Iterator<E> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<E> implements Iterator<E> {
        private Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("empty ");
            }
            E elemet = (E) current.element;
            current = current.next;
            return elemet;
        }
    }


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedQueue<>(10);
        System.out.println("size " + q.size());
        q.enqueue(1);
        q.enqueue(2);
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);
//        q.enqueue(6);
        System.out.println("size " + q.size());
        System.out.println("peek " + q.peek());
        System.out.println("remove " + q.dequeue());
        System.out.println("size " + q.size());
        System.out.println("peek " + q.dequeue());
        System.out.println("peek ex" + q.dequeue());
    }
}


