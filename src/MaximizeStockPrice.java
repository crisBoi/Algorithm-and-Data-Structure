import java.security.KeyPair;
import java.util.Map;

public class MaximizeStockPrice {
    public static void main(String[] args) {

    }
}

class Stock {
    int maxStockPrice(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }

        int sumArr[] = new int[prices.length];

        for (int j = 0; j < prices.length; j++) {
            sumArr[j] = sum - prices[j];
        }

        int min = sumArr[0];
        int minIndex = 0;

        for (int k = 0; k < sumArr.length; k++) {
            if (sumArr[k] < min) {
                min = sumArr[k];
                minIndex = k;
            }
        }


       // Map<Integer, Pair<Integer, Integer>>
        return sum;
    }
}
