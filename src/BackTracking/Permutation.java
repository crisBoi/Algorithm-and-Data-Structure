package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3};
        int[] test2 = new int[]{0, 1};

        String test3 = "caabbd";

//        for(int i = 0; i < test3.length(); i++) {
//            System.out.println("i: " + i + " i+1: " + (i + 1) + " " + test3.substring(i + 1));
//        }

        List<String> list = new ArrayList<>();
        list.add(0, "a");
        list.add(0, "b");
        list.add(0, "c");
        System.out.println("res: " + Arrays.toString(list.toArray()));


//        SolPurm sol = new SolPurm();
//        sol.getAllCombinations(0, test1);
//        sol.print();
    }
}

class SolPurm{
    List<List<Integer>> ans;
    List<Integer> combination;


    SolPurm() {
        ans = new ArrayList<>();
        combination = new ArrayList<>();
    }

    void getAllCombinations(int currentIndex, int nums[]) {
        if (combination.size() >= nums.length) {
            ans.add(new ArrayList<>(combination));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i != currentIndex) {
                    combination.add(nums[i]);
                    getAllCombinations(currentIndex + 1, nums);
                    combination.remove(combination.size() - 1);
                    
                }
            }
        }
    }

    void print() {
        System.out.println("size: " + ans.size());
        for (List<Integer> list: ans) {
            System.out.print(Arrays.toString(list.toArray()));
        }
        System.out.println();
    }
}
