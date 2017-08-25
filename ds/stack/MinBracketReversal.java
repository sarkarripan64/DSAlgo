package ds.stack;

import java.util.Stack;

/**
 * Created by sarkarri on 4/13/17.
 */
public class MinBracketReversal {
    public static void main(String[] args) {
        String s = "}}}{{{";
        s = "{{{{}}";
        s = "}{{}}{{{";
        System.out.println(minNoOfReversal(s));
    }

    static int minNoOfReversal(String str) {
        if (str.length() % 2 != 0)
            return 0;

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '}') {
                if (!s.isEmpty() && s.peek() == '{') {
                    s.pop();
                } else {
                    s.push(str.charAt(i));
                }
            } else {
                s.push(str.charAt(i));
            }
        }


        int left = s.size();
        int ob = 0;
        while (!s.isEmpty()) {
            if (s.pop() == '{') {
                ob++;
            }
        }

        return (left / 2 + ob % 2);
    }

}
