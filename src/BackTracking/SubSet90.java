package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet90 {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3};
        int[] test2 = new int[]{1, 2, 2};
        int[] test3 = new int[]{0, 1};
        int[] test4 = new int[]{2, 1, 2};

//        Sol90 sol1 = new Sol90();
//        sol1.backTrack(0, test1);
//        sol1.print();

        Sol90 sol2 = new Sol90();
        Arrays.sort(test4);
        sol2.backTrack(0, test4);
        sol2.print();
//
//        Sol90 sol3 = new Sol90();
//        sol3.backTrack(0, test3);
//        sol3.print();
    }
}

class Sol90 {
    List<List<Integer>> ans;
    List<Integer> subset;

    Sol90() {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
    }
    void backTrack(int start, int[] nums) {
        ans.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            backTrack(i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }

    void print() {
        for (List<Integer> nums: ans) {
            System.out.println(Arrays.toString(nums.toArray()));
        }
    }
}
