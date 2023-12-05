package TwoPointers;

public class TwoSumSorted167 {
    public static void main(String[] args) {

    }
}

class Sol167 {
    public int[] getIndices(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > target) {
                    break;
                } else if (nums[i] + nums[j] == target) {
                        return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{};
    }

    public int[] optimized(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;

        while (numbers[start] + numbers[end] != target) {
            if (numbers[start] + numbers[end] > target) end--;
            else start++;
        }

        return new int[]{start + 1, end + 1};
    }
}
