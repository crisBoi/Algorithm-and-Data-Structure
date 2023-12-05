package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmaller {
    public static void main(String[] args) {
        int[] test1 = new int[]{4, 5, 1, 6, 2, 8, 9, 3};
        SolNS sol = new SolNS();

        System.out.println("res: " + Arrays.toString(sol.getNextSmaller(test1)));
    }
}

class SolNS {
    int[] getNextSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nsIndex = new int[nums.length];

        Arrays.fill(nsIndex, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nsIndex[stack.pop()] = i;
            }

            stack.push(i);
        }

        int[] ns = new int[nums.length];
        Arrays.fill(ns, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nsIndex[i] != -1) {
                ns[i] = nums[nsIndex[i]];
            }
        }

        return ns;
    }
}
