package BinarySearch;

public class MedianTwoSortedArr4 {
    public static void main(String[] args) {
        int[] test1arr1 = new int[]{2, 3, 4, 6};
        int[] test1arr2 = new int[]{8, 10, 12, 14, 20, 21}; //9.0

        int[] test2arr1 = new int[]{1, 3};
        int[] test2arr2 = new int[]{2}; //2.0

        int[] test3arr1 = new int[]{1, 2};
        int[] test3arr2 = new int[]{3, 4}; //2.5

        int[] test4arr1 = new int[]{3, 4};
        int[] test4arr2 = new int[]{1, 2}; //2.5


        Sol4 sol = new Sol4();
//        sol.findMedianSortedArrays(test1arr1, test1arr2);
        System.out.println("median: " + sol.findMedianSortedArrays(test1arr1, test1arr2));
        System.out.println("median: " + sol.findMedianSortedArrays(test2arr1, test2arr2));
        System.out.println("median: " + sol.findMedianSortedArrays(test3arr1, test3arr2));
        System.out.println("median: " + sol.findMedianSortedArrays(test4arr1, test4arr2));
    }
}

class Sol4 {
    public double getMedianSortedArray(int[] arr1, int[] arr2) {

        if (arr1.length > arr2.length) {
            return getMedianSortedArray(arr2, arr1);
        }

        int total = arr1.length + arr2.length;
        int half = (total + 1) / 2;

        int l = 0, r = arr1.length;

        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;

            int l1 = i > 0 ? arr1[i - 1] : Integer.MIN_VALUE;
            int r1 = i < arr1.length ? arr1[i] : Integer.MAX_VALUE;

            int l2 = j > 0 ? arr2[j - 1] : Integer.MIN_VALUE;
            int r2 = j < arr2.length ? arr2[j] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (total % 2 == 0) {
                    return (double) ((Math.max(l1, l2) + Math.min(r1, r2))) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
    }
}