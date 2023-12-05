package BinarySearch;

import java.util.Arrays;

public class SearchA2DMatrix74 {
    public static void main(String[] args) {
        int[][] test1 = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{10, 11, 14, 19, 20},
                new int[]{21, 23, 24, 25, 30},
        };

        int[][] test2 = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{10, 11, 14, 20},
                new int[]{21, 24, 25, 30},
                new int[]{31, 33, 34, 40},
                new int[]{21, 24, 25, 50},
                new int[]{21, 24, 25, 60},
                new int[]{21, 24, 25, 70},
        };
        int[][] test3 = new int[][]{
                new int[]{1, 2, 3, 4, 7},
                new int[]{10, 11, 14, 20},
                new int[]{23, 24, 25, 60},
        };

        int[][] test4 = new int[][]{
                new int[]{1, 2, 3, 4, 7},
                new int[]{10, 11, 14, 21},
                new int[]{21, 24, 25, 30},
                new int[]{31, 33, 34, 40},
                new int[]{21, 24, 25, 50},
                new int[]{21, 24, 25, 60},
                new int[]{21, 24, 25, 70},
        };

        int[][] test5 = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}
        };

        int[] x = test4[0];

        Sol74 sol = new Sol74();

        int row = sol.returnRow(test5, 23);
        System.out.println("row: " + Arrays.toString(test1[row]));

    }
}

class Sol74 {
    int returnRow(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        int top = 0, bottom = rows, mid = (top + bottom) / 2;

        while (top <= bottom) {
            if (target < matrix[mid][cols] && target < matrix[mid][0]) {
                bottom = mid - 1;
                mid = (top + bottom) / 2;
            } else if (target > matrix[mid][cols] && target > matrix[mid][cols]) {
                top = mid + 1;
                mid = (top + bottom) / 2;
            } else {
                break;
            }
        }
//        if (target > matrix[mid][cols] && mid + 1 <= rows) {
//            return mid + 1;
//        } else if (target < matrix[mid][cols] && mid - 1 >= 0) {
//            return mid - 1;
//        }

        return mid;
    }

    int searchNum(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = (nums.length - 1) / 2;

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
