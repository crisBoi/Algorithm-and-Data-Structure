package Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        int[] test1 = new int[]{4, 5, 1, 6, 2, 8, 9, 3};
        int[] test2 = new int[]{2,1,5,6,2,3};
        int[] test3 = new int[]{2,4};

        Sol84 sol = new Sol84();
        System.out.println("max: " + sol.maxArea(test3))

        ;

    }
}

class Sol84 {
   /* public int maxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int currMax = 0;
        int size = 0;
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                max = currMax = heights[i];
                stack.push(heights[i]);
                continue;
            } else if (heights[i] > (currMax / stack.size()) && heights[i] > currMax) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
    }*/

    public int maxArea(int[] height) {
        Stack<Integer> pStack = new Stack<>();

        int[] psIndex = new int[height.length];
        Arrays.fill(psIndex, -1);

        for (int i = 0; i < height.length; i++) {
            while (!pStack.isEmpty() && height[pStack.peek()] >= height[i]) {
                pStack.pop();
            }

            if (!pStack.isEmpty()) {
                psIndex[i] = pStack.peek();
            }

            pStack.push(i);
        }

        Stack<Integer> nStack = new Stack<>();

        int[] nsIndex = new int[height.length];
        Arrays.fill(nsIndex, height.length);

        for (int i = 0; i < height.length; i++) {
            while (!nStack.isEmpty() && height[nStack.peek()] >= height[i]) {
                nsIndex[nStack.pop()] = i;
            }

            nStack.push(i);
        }

        int[] res = new int[height.length];
        int max = Integer.MIN_VALUE;

        for (int j = 0; j < height.length; j++) {
            int area = ((nsIndex[j] - psIndex[j]) - 1) * height[j];
            res[j] = area;
            max = Math.max(max, area);


        }

//        System.out.println("pSmaller: " + Arrays.toString(psIndex));
//        System.out.println("nSmaller: " + Arrays.toString(nsIndex));
//
//        System.out.println("res arr: " + Arrays.toString(res));

        return max;
    }
}
