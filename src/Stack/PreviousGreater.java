package Stack;

import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

public class PreviousGreater {
    public static void main(String[] args) {
        System.out.printf("res: " + Arrays.toString(new SolPG().previousGreater(new int[] {13, 8, 1, 5, 2, 5, 9, 7, 6, 12})));
    }
}

class SolPG {
    int[] previousGreater(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }
}
