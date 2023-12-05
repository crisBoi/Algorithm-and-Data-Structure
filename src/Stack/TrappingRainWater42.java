package Stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] test1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; //6
        int[] test2 = new int[]{4, 2, 0, 3, 2, 5}; //9
        int[] test3 = new int[]{4, 2, 3}; //1
        int[] test4 = new int[]{2, 1, 0, 1, 3}; // 4

        Sol42 sol = new Sol42();


        System.out.println("total water: " + sol.trap(test4));
    }
}

class Sol42 {
    int getMaxArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int stackPop = stack.pop();

                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()], height[i]) - height[stackPop];

                    int w = i - (stack.peek() + 1);

                    totalWater += h * w;
                }
            }

            stack.push(i);
        }


        return totalWater;
    }


    public int trap(int[] height) {
       if (height.length == 0) {
           return 0;
       }

       int totalWater = 0;

       int lMax = 0, rMax = 0;
       int l = 0, r = height.length - 1;

       while (l < r) {
           if (height[l] < height[r]) {
               if (height[l] >= lMax) {
                   lMax = height[l];
               } else {
                   totalWater += lMax - height[l];
               }
               l++;

           } else {
               if (height[r] >= rMax) {
                   rMax = height[r];
               } else {
                   totalWater += rMax - height[r];
               }
               r--;
           }
       }

       return totalWater;
    }
}
