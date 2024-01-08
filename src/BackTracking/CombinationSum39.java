package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] test1 = new int[]{2,3,6,7};


        Sol39 sol = new Sol39();
//        sol.helper(test1, 0, new ArrayList<>(), 0, 7);
        sol.backtrack(test1, 0, new ArrayList<>(), 7);
        sol.print();
    }
}

class Sol39 {
    List<List<Integer>> ans;

    Sol39() {
        ans = new ArrayList<>();
    }

    void helper(int[] nums, int currentIndex, List<Integer> combination, int sum, int targetSum) {
        if (sum == targetSum) {
            ans.add(new ArrayList<>(combination));
        } else if (sum > targetSum || currentIndex >= nums.length) {
            return;
        } else {
            combination.add(nums[currentIndex]);
            helper(nums, currentIndex, combination, sum + nums[currentIndex], targetSum);

            combination.remove(combination.size() - 1);
            helper(nums, currentIndex + 1, combination, sum, targetSum);
        }
    }

    void print() {
        System.out.println("size: " + ans.size());
        for(List<Integer> arr: ans) {
            System.out.print(Arrays.toString(arr.toArray()));
        }
        System.out.println("");
    }

    void backtrack(int[] nums, int index, List<Integer> temp, int sum) {
        if (sum == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        } else if (sum < 0){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i, temp, sum - nums[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
