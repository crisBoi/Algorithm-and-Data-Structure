import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }
}

class Parentheses {
    boolean checkParentheses(String s) {
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ch == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && ch == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }

        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
