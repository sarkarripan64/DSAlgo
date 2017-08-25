package ds.stack;

import java.util.Arrays;

/**
 * Created by sarkarri on 11/25/16.
 */
public class MyStack<E> {
    int top = -1;
    int capacity = 10;
    Object[] holder;

    public MyStack(int capacity) {
        this.capacity = capacity;
        holder = new Object[capacity];

        /*java.util.MyStack stack = new java.util.MyStack();
        stack.add();*/
    }

    public MyStack() {
        this(10);
    }


    public <E> void push(E element) {
        ensureCapacity();
        System.out.println("top " + top);
        holder[++top] = element;
    }

    public E pop() {
        return (E) holder[top--];
    }

    public int size() {
        return top;
    }

    private void ensureCapacity() {
        //System.out.println("holder.length "+holder.length);
        if (size() == holder.length-1) {
            holder = Arrays.copyOf(holder, 2 * holder.length);
        }
    }

    public static void main(String[] args) {
        MyStack<String> intSt = new MyStack<>(5);
        intSt.push("1");
        intSt.push("2");
        intSt.push("3");
        intSt.push("4");
        intSt.push("5");
        intSt.push("6");
        intSt.push("7");
        intSt.push("8");
        intSt.push("9");
        intSt.push("10");
        intSt.push("11");
        intSt.push("12");
        intSt.push("13");



        System.out.println("ssdas " + intSt.pop());
        System.out.println("ssdas " + intSt.pop());
        System.out.println("ssdas " + intSt.pop());


    }
}
