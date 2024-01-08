package BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum40 {
    public static void main(String[] args) {
        int[] test1 = new int[]{2, 4, 3}; //[2, 3], t = 5
        int[] test2 = new int[]{10,1,2,7,6,1,5}; //[[1,1,6], [1,2,5], [1,7], [2,6]], t = 8
        int[] test3 = new int[]{2,5,2,1,2}; //[[1,2,2], [5]], t = 5

//        Sol40 sol1 = new Sol40();
//        sol1.backTrack(test1, 0, 0, 5);;
//        sol1.print();
//
//        Sol40 sol2 = new Sol40();
//        Arrays.sort(test2);
//        sol2.backTrack(test2, 0, 0, 8);;
//        sol2.print();

        Sol40 sol3 = new Sol40();
        Arrays.sort(test3);
        sol3.backTrack(test3, 0, 0, 5);;
        sol3.print();

    }
}

class Sol40 {
    List<List<Integer>> ans;
    List<Integer> subset;

    Sol40() {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
    }

    void backTrack(int[] nums, int start, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(subset));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backTrack(nums,  i + 1, sum + nums[i], target);
            subset.remove(subset.size() - 1);
        }
    }

    void print() {
        for(List<Integer> nums: ans) {
            System.out.print(Arrays.toString(nums.toArray()));
        }
        System.out.println();
    }
}
