package BinarySearch;

public class FindMinRotatedSortedArr153 {
    public static void main(String[] args) {
        int[] test1 = new int[]{3,4,5,1,2}; //1
        int[] test2 = new int[]{4,5,6,7,0,1,2}; //0
        int[] test3 = new int[]{11,13,15,17}; //11

        Sol153 sol = new Sol153();
        System.out.println("res: " + sol.getMin(test1));
        System.out.println("res: " + sol.getMin(test2));
        System.out.println("res: " + sol.getMin(test3));

    }
}

class Sol153 {
    int getMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int m = (l + r) / 2;

            min = Math.min(min, nums[m]);

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else  {
                r = m -1;
            }
        }

        return min;
    }
}
