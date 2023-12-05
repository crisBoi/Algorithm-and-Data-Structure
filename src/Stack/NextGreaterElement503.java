package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement503 {
    public static void main(String[] args) {
        Sol503 sol = new Sol503();

    }
}

class Sol503 {
        int[] nextGreater(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[nums.length];

            Arrays.fill(result, -1);

            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < result.length; i++) {
                    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                        int popIndex = stack.pop();
                        result[popIndex] = nums[i];
                    }
                    stack.push(i);
                }
            }

            return result;
        }
}
