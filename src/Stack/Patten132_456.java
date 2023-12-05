package Stack;

import java.util.Stack;

public class Patten132_456 {
    public static void main(String[] args) {
        Sol456 sol = new Sol456();
        boolean isPatternExist = sol.bruteForce(new int[]{3, 1, 4, 2});

        System.out.printf("result: " + isPatternExist);
    }
}

class Sol456 {
    boolean bruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i + 1 < nums.length) {
                if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i] && nums[i - 1] < nums[i + 1]) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean findPattern(int[] num) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length; i++) {
            if (!stack.isEmpty() && num[stack.peek()] > num[i]) {
              stack.pop();
            }

            if (!stack.isEmpty()) {
                if (num[stack.peek()] < num[i]) {
                    return true;
                }
            }

            stack.push(i);
        }

        return false;
    }

    boolean findPattern123(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] minimum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                minimum[i] = 0;
            } else {
                if (nums[minimum[i - 1]] < nums[i]) {
                    minimum[i] = minimum[i - 1];
                } else {
                    minimum[i] = i;
                }
            }

            while (!stack.isEmpty() && nums[stack.peek()] <=     nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                if (nums[minimum[stack.peek()]] < nums[i]) {
                    return true;
                }
            }

            stack.push(i);
        }

        return true;
    }
}

