package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreater496 {
    public static void main(String[] args) {
        Sol496 sol = new Sol496();
        System.out.println("res: " + Arrays.toString(sol.nextGreater(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}

class Sol496 {
    public int[] nextGreater(int[] num1, int[] num2) {
        Stack<Integer> stack = new Stack<>();
        int[] allRes = new int[num2.length];

        Arrays.fill(allRes, -1);

        for (int i = 0; i < num2.length; i++) {
            while (!stack.isEmpty() && num2[stack.peek()] < num2[i]) {
                allRes[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }



        int[] res = new int[num1.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                if (num1[i] == num2[j]) {
                    if (allRes[j] != -1) {
                        res[i] = num2[allRes[j]];
                    } else {
                        res[i] = -1;
                    }
                    break;
                }
            }
        }

        return res;
    }

    int[] optimized(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int n: nums2) {
            while (!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}
