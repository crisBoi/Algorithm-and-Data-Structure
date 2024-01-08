package SlidingWindow;

public class BuyAndSellStocks121 {
    public static void main(String[] args) {
        int[] test1 = new int[]{7, 1, 5, 3, 6, 4}; //5
        int[] test2 = new int[]{7, 6, 4, 3, 1}; //0
        int[] test3 = new int[]{1, 2, 3, 4, 5}; //4
        int[] test4 = new int[]{8, 7, 6, 5, 4, 1, 8, 10, 0, 20}; //20

        Sol121 sol = new Sol121();

        System.out.println("res: " + sol.getMaxProfit(test1));
        System.out.println("res: " + sol.getMaxProfit(test2));
        System.out.println("res: " + sol.getMaxProfit(test3));
        System.out.println("res: " + sol.getMaxProfit(test4));
    }
}

class Sol121 {
    int getMaxProfit(int[] nums) {
        int profit = 0;

        int i = 0;
        int j = i+1;
        int maxProfit = 0;

        while (j < nums.length) {
            if (nums[j] < nums[i]) {
                i++;
            } else if (i == j) {
                j++;
            } else {
                maxProfit = Math.max(maxProfit, nums[j] - nums[i]);
                j++;
            }
        }

        return maxProfit;
    }
}
