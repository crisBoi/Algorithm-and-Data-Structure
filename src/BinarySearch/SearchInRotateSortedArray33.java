package BinarySearch;

public class SearchInRotateSortedArray33 {
    public static void main(String[] args) {
        int[] test1 = new int[]{4,5,6,7,0,1,2};
        int[] test2 = new int[]{1};
        int[] test3 = new int[]{4,5,6,7,8,1,2,3};
        int[] test4 = new int[]{5, 1, 3};
        int[] test5 = new int[]{3, 1};

        Sol33 sol = new Sol33();
        System.out.println("res: " + sol.search(test5, 1));
//        System.out.println("res: " + sol.search(test1, 2));
//        System.out.println("res: " + sol.search(test1, 8));
//        System.out.println("res: " + sol.search(test3, 8));
    }
}

class Sol33 {
    int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;


        while (l <= r) {
            int m = (l + r) / 2;
            System.out.print("l: " + l + " r: " + r);
            System.out.println(" m: " + m);

            if (target == nums[m]) {
                return m;
//            } else if (target > nums[m]) {
//
//                    if (nums[l] >= target) {
//                        r = m - 1;
//                    } else {
//                        l = m + 1;
//                    }
//
//            } else if (target < nums[m]) {
//                if (nums[l] <= target) {
//                    r = m - 1;
//                } else {
//                    l = m + 1;
//                }
//            }

            } else if (nums[l] < nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

        }

        return -1;
    }
}
