package BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3}; //[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        int[] test2 = new int[]{0}; //[[][0]]
        int[] test3 = new int[]{}; //[]

        Sol78 sol1 = new Sol78();
        sol1.recursiveList(0, test1);
        sol1.print();

        Sol78 sol2 = new Sol78();
        sol2.recursiveList(0, test2);
        sol2.print();

        Sol78 sol3 = new Sol78();
        sol3.recursiveList(0, test3);
        sol3.print();
        /*for (int i = 0; i < sol.ans.size(); i++) {
            System.out.print(Arrays.toString(sol.ans.get(i).toArray()) + " ");
        }*/
    }
}

class Sol78 {
    List<List<Integer>> ans;
    List<Integer> subset;

    Sol78() {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
    }

    void recursiveList(int currentIndex, int[] nums) {
        if (currentIndex >= nums.length) {
            ans.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[currentIndex]);
            recursiveList(currentIndex + 1, nums);

            subset.remove(subset.size() - 1);
            recursiveList(currentIndex + 1, nums);
        }
    }

    void print() {
        for(List<Integer> arr: ans) {
            System.out.print(Arrays.toString(arr.toArray()));
        }
        System.out.println("");
    }
}
