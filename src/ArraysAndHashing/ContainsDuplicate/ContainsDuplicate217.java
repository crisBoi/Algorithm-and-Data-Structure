package ArraysAndHashing.ContainsDuplicate;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public static void main(String[] args) {

    }
}

class ContainsDuplicateSol {
    boolean isDuplicatePresent(int[] nums) {

        HashSet<Integer> distinctList = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (distinctList.contains(nums[i])) {
                return true;
            }

            distinctList.add(nums[i]);
        }

        return false;
    }
}
