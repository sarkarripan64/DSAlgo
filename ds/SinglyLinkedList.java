package ds;

import java.util.*;

/**
 * Created by sarkarri on 12/5/16.
 */
public class SinglyLinkedList<E> implements Deque<E> {
    int size;
    private Node head;

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);
        list.add(35);
        list.add(40);

        list.removeLast();
        list.removeFirst();
        System.out.println("list " + list);
        System.out.println("contains " + list.contains(25));
        list.reverse();
        System.out.println("after reverse "+list);
        Iterator it = list.iterator();
        while (it.hasNext()){
            Integer in = (Integer) it.next();
            System.out.printf(" innn "+in);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(o))
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<E>();
    }

    private class ListIterator<E> implements Iterator<E> {
        Node temp = head;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException("No data");

            E data = (E) temp.data;
            temp = temp.next;
            return data;
        }
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public void addFirst(E e) {
        if (isEmpty())
            head = new Node(e);
        else {
            Node temp = head;
            head = new Node(e);
            head.next = temp;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        if (isEmpty()) {
            head = new Node(e);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(e);
        }
        size++;
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("no data");
        }
        Node temp = head;
        head = head.next;
        size--;
        return (E) temp.data;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("no data");
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        E e = (E) temp.data;
        temp = null;
        System.out.println("temp " + temp);
        size--;
        return e;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty");
        }

        return (E) head.data;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void add(int index, E element) {
        checkIndex(index);

        if (index == 0)
            addFirst(element);
        if (index == size())
            addLast(element);

        addAfter(element, node(index));
    }

    private void addAfter(E element, Node<E> node) {
        Node next = node.next;
        Node newEle = new Node(element);
        newEle.next = next;
        node.next = newEle;
        size++;
    }

    public void reverse() {
        Node current = head;
        Node next, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    Node<E> node(int index) {
        Node temp = head;
        if (index < (size() >> 1)) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            for (int i = size() >> 1; i <= index; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    private void checkIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }


    @Override
    public E remove() {
        return removeFirst();
    }

    public E remove(int index) {
        checkIndex(index);
        if (index == 0)
            return removeFirst();
        if (index == size() - 1)
            return removeLast();

        return removeAfter(node(index - 1));
    }

    private E removeAfter(Node<E> element) {
        Node temp = element.next;
        element.next = temp.next;
        E data = (E) temp.data;
        temp = null;
        return data;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    private class Node<E> {
        E data;
        Node next;

        Node() {
        }

        Node(E element) {
            data = element;
        }
    }

    @Override
    public String toString() {
        Iterator it = iterator();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (it.hasNext()) {
            E e = (E) it.next();
            sb.append(e);
            if (it.hasNext())
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
