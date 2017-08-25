package ds.stack;

import java.util.Stack;

/**
 * Created by sarkarri on 4/4/17.
 */
public class BalancedParenthesies {
    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}";
        System.out.println(checkBalanced(s));
    }

    static boolean checkBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if ((ch == ')' || ch == '}' || ch == ']') && !stack.isEmpty()) {
                char temp = stack.pop();
                if (ch == ')' && temp != '(')
                    return false;
                if (ch == '}' && temp != '{')
                    return false;
                if (ch == ')' && temp != '(')
                    return false;

            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
