package ds.stack;

import java.util.Stack;

/**
 * Created by sarkarri on 4/10/17.
 */
public class InfixToPostFixConversion {
    public static void main(String[] args) {
        String ip1 = "124*5/+7-36/+";
        String ip2 = "a+b*(c+d)";
        String ip3 = "a+b*c+d";
        System.out.println(convert(ip1));
    }

    static String convert(String infix) {
        String result = "";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetter(c)) {
                result = result + c;
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    result = result + s.pop();
                }

                s.pop();
            } else {
                while (!s.isEmpty() && !(s.peek() == '(') && getPrecedence(c) <= getPrecedence(s.peek())) {
                    result = result + s.pop();
                }
                s.push(c);
            }
        }

        while (!s.isEmpty()) {
            result = result + s.pop();
        }


        return result;
    }

    private static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
            case '%':
                return 2;
        }

        return 0;
    }
}
