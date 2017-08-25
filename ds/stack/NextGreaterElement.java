package ds.stack;

import java.util.Stack;

/**
 * Created by sarkarri on 4/5/17.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        //int arr[] = {11, 13, 21, 3};
        int arr[] = {4, 5, 2, 25};
        nextGreaterElements(arr);
    }

    static void nextGreaterElements(int ar[]) {
        Stack<Integer> s = new Stack<>();

        s.push(ar[0]);

        for (int i = 1; i < ar.length; i++) {
            int next = ar[i];
            while (!s.isEmpty() && next > s.peek()) {
                System.out.println(s.pop() + " -- >" + next);
            }

            s.push(ar[i]);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop() + " --> " + -1);
        }
    }
}
