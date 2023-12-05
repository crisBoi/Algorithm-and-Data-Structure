package TwoPointers;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum15 {
    public static void main(String[] args) {

        int[] test1 = new int[]{-1,0,1,2,-1,-4}; // -4, -1, -1, 0, 1, 2
        int[] test2 = new int[]{-2, 0, 0, 2, 2}; // -2, 0, 0, 2, 2

        Sol15 sol = new Sol15();
        System.out.println("res: " + sol.threeSumHelper(test2));
    }
}

class Sol15 {
    public List<List<Integer>> threeSumHelper(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int target = -(nums[i]);

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSumWithSet(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        if (nums.length == 0) return new ArrayList<>(res);

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                else if (sum > 0) r--;
                else l++;
            }
        }

        return new ArrayList<>(res);
    }
}
