package Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses22 {
    public static void main(String[] args) {

    }
}

class Sol22 {
    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    void backtrack(int openN, int closeN, int n) {
        if (openN == closeN && closeN == n) {
            Iterator<Character> vale = stack.iterator();
            StringBuilder temp = new StringBuilder();

            while (vale.hasNext()) {
                temp.append(vale.next());
            }

            res.add(temp.toString());
        }

        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closeN, n);;
            stack.pop();
        }

        if (closeN < openN) {
            stack.push(')');
            backtrack(openN, closeN + 1, n);
            stack.pop();
        }
    }


    void optimized(int opnN, int closeN, String s, int n) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        if (opnN < n) {
            optimized(opnN + 1, closeN, s + "(", n);
        }

        if (closeN < opnN) {
            optimized(opnN, closeN + 1, s + ")", n);
        }
    }
}
