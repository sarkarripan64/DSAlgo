package ds.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by sarkarri on 4/5/17.
 */
public class TwoStackWithArray<E> {
    E[] ar;
    Stack<E> s1;
    Stack<E> s2;
    int top1 = -1;
    int top2, size;


    TwoStackWithArray(int n) {
        ar = (E[]) new Object[n];
        s1 = new Stack<E>();
        s2 = new Stack<E>();
        size = n;
        top2 = n;
    }

    public static void main(String[] args) {
        TwoStackWithArray tsa = new TwoStackWithArray(4);
        tsa.push1(1);
        tsa.push1(2);
        tsa.push1(3);
        //tsa.push2(4);

        System.out.println(tsa.pop1());
        System.out.println(tsa.pop1());
        System.out.println(tsa.pop1());
        //System.out.println(tsa.pop2());


    }

    void push1(E element) {
        if (top1 < top2 - 1) {
            ar[++top1] = element;
        } else {
            throw new StackOverflowError("Stack is full");
        }
    }

    void push2(E element) {
        if (top1 < top2 - 1) {
            ar[--top2] = element;
        } else {
            throw new StackOverflowError("Stack is full");
        }
    }

    E pop1() {
        if (top1 < 0 || top1 >= size) {
            throw new NoSuchElementException("Stack is empty");
        }

        return ar[top1--];
    }

    E pop2() {
        if (top2 < 0 || top2 >= size) {
            throw new NoSuchElementException("Stack is empty");
        }

        return ar[top2++];
    }


}
