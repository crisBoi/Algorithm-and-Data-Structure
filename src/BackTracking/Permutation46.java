package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation46 {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3};
        int[] test2 = new int[]{0, 1};

        Sol46 sol = new Sol46();
//        sol.dfs(0, test1);
        sol.backTrack(test1, 0, new ArrayList<>());
        sol.print();
    }
}

class Sol46 {
    List<List<Integer>> ans;

    Sol46() {
        ans = new ArrayList<>();
    }
    void dfs(int start, int[] nums) {
       if (start >= nums.length) {
           List<Integer> perm = new ArrayList<>();
           for (int num : nums) {
               perm.add(num);
           }

           ans.add(perm);
           return;
       }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            dfs(start + 1, nums);
            swap(nums, start, i);
        }

    }

    void swap(int[] nums, int start, int i) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

    void print() {
        System.out.println("size: " + ans.size());
        for(List<Integer> list: ans) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    void backTrack(int[] nums, int index, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            ans.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backTrack(nums, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

}
