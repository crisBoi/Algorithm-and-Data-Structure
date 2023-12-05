package TwoPointers;

public class ContainerWIthMostWater11 {
    public static void main(String[] args) {

    }
}

class Sol11 {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;

        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int steps = r - l;
            int area = Math.min(height[l], height[r]) * steps;
            max = Math.max(area, max);

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}
