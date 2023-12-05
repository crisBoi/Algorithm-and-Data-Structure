package Stack;

import java.util.Stack;

public class MinStack155 {
    public static void main(String[] args) {

    }
}

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty()) {
            minStack.push(val);
            return;
        }

        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        if (stack.isEmpty()) return;

        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
