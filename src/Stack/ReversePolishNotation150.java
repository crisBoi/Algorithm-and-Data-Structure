package Stack;

import java.util.Stack;

public class ReversePolishNotation150 {
    public static void main(String[] args) {
        String[] tokens1 = new String[]{"2", "1", "+", "3", "*"};
        String[] tokens2 = new String[]{"4","13","5","/","+"};
        String[] tokens3 = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};


        for (int i = 0; i < tokens3.length; i++) {
            System.out.print(tokens3[i] + ": ");
            if (tokens3[i].matches("^[+-]?\\d+")) {
                System.out.println("is digit");
            } else {
                System.out.println("is not digit");
            }
        }

       // System.out.println("ans: " + new Sol150().evaluate(tokens3));
    }
}

class Sol150 {
    public int evaluate(String[] token) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < token.length; i++) {
            if (Character.isDigit(token[i].charAt(0))) {
                stack.push(token[i]);
            } else {
                int value = compute(token[i], Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()));
                stack.push(value + "");
            }

        }

        return Integer.parseInt(stack.peek());
    }
    private int compute(String operator, int op1, int op2) {
        return switch (operator) {
            case "+" -> op2 + op1;
            case "-" -> op2 - op1;
            case "*" -> op2 * op1;
            case "/" -> op2 / op1;
            default -> Integer.MIN_VALUE;
        };

    }

    public int optimised(String[] token) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < token.length; i++) {
            switch (token[i]) {
                case "+" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1 + op2);
                }
                case "-" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 - op1);
                }
                case "*" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op1 * op2);
                }
                case "/" -> {
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(op2 / op1);
                }
                default -> {
                    stack.push(Integer.parseInt(token[i]));
                }
            }

        }

        return stack.pop();
    }
}
