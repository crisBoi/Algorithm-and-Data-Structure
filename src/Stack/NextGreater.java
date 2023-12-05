package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        Sol sol = new Sol();
        System.out.printf("ans: " + Arrays.toString(sol.nextGreater(new int[]{13, 8, 1, 5, 2, 5, 9, 7, 6, 12})));;
    }
}

class Sol {
    int[] nextGreater(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}
