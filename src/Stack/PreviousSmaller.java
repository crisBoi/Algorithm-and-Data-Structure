package Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class PreviousSmaller {
    public static void main(String[] args) {
        int[] test1 = new int[]{2, 1, 6, 5, 4, 3, 1}; //-1, -1, 1, 1, 1, 1 -1
        SolPS sol = new SolPS();
        System.out.println("res: " + Arrays.toString(sol.getPreviousSmaller(test1)));
    }
}

class SolPS {
    public int[] getPreviousSmaller(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] psIndex = new int[heights.length];

        Arrays.fill(psIndex, -1);

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                psIndex[i] = stack.peek();
            }

            stack.push(i);
        }

        int[] ps = new int[heights.length];
        Arrays.fill(ps, -1);

        for (int i = 0; i < heights.length; i++) {
            if (psIndex[i] != -1) {
                ps[i] =  heights[psIndex[i]];
            }
        }

        return ps;
    }
}
