package BinarySearch;

public class BinarySearch704 {
    public static void main(String[] args) {
        int[] test1 = new int[]{-1,0,3,5,9,12};
        int[] test2 = new int[]{1, 2, 3, 4};

        System.out.println("divide 0: " + (0/2));

        Sol704 sol = new Sol704();
        System.out.println("res: " + sol.searchNum(test1, -1));
        System.out.println("res: " + sol.searchNum(test1, 0));
        System.out.println("res: " + sol.searchNum(test1, 3));
        System.out.println("res: " + sol.searchNum(test1, 5));
        System.out.println("res: " + sol.searchNum(test1, 9));
        System.out.println("res: " + sol.searchNum(test1, 12));
    }
}

class Sol704 {
    int searchNum(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = (nums.length - 1)/ 2;

        while (l <= r) {
            if (target > nums[m]) {
                l = m + 1;
                m = (l + r) / 2;
            } else if (target < nums[m]) {
                r = m - 1;
                m = (l + r) / 2;
            } else {
                return m;
            }
        }

        return -1;
    }
}
