package Stack;

import java.util.Stack;

public class ValidParentheses20 {
}

class Sol20 {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}') {
                if (charStack.isEmpty()) {
                    return false;
                }

                if (charStack.peek() != '{') {
                    return false;
                }
                charStack.pop();
                continue;
            }

            if (s.charAt(i) == ']') {
                if (charStack.isEmpty()) {
                    return false;
                }

                if (charStack.peek() != '[') {
                    return false;
                }
                charStack.pop();
                continue;
            }

            if (s.charAt(i) == ')') {
                if (charStack.isEmpty()) {
                    return false;
                }

                if (charStack.peek() != '(') {
                    return false;
                }
                charStack.pop();
                continue;
            }

            charStack.add(s.charAt(i));
        }

        return charStack.isEmpty();
    }
}
