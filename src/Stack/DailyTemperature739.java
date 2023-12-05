package Stack;

import java.util.Stack;

public class DailyTemperature739 {
    public static void main(String[] args) {

    }
}

class Sol739 {
    public int[] nextTemp(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int currentDay = 0; currentDay < temperatures.length; currentDay++ ) {
            while (!stack.isEmpty() && temperatures[currentDay] > temperatures[stack.peek()]) {
                result[stack.peek()] =  currentDay - stack.peek();
                stack.pop();
            }
            stack.push(currentDay);
        }

        return result;
    }

    public int[] optimized(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
                result[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }

        return result;
    }
}