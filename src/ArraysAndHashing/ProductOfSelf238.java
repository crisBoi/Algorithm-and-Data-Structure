package ArraysAndHashing;

import java.util.Arrays;

public class ProductOfSelf238 {
    public static void main(String[] args) {
        Sol238 sol = new Sol238();
        int[] result = sol.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.printf("result: " + Arrays.toString(result));
    }
}

class Sol238 {
    public int[] productExceptSelf(int nums[]) {
        int[] result = new int[nums.length];

        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i]= prefix;
            prefix *= nums[i];
        }

        int postfix = 1;

        for (int j = nums.length - 1; j >= 0 ; j--) {
            result[j] = result[j] * postfix;
            postfix *= nums[j];
        }

        return result;
    }
}
