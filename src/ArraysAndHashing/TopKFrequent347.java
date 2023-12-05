package ArraysAndHashing;

import java.util.*;

public class TopKFrequent347 {
    public static void main(String[] args) {
        Sol374 sol = new Sol374();
        int[] result = sol.getTopKHelper(new int[]{1}, 1);
        System.out.println("" + Arrays.toString(result));
    }
}

class Sol374 {
    int[] getTopKHelper(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i < nums.length + 1; i++) {
            bucket.add(i, new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int[] result = new int[k];
        int i = 0;

        for (int j = bucket.size() - 1; j > 0; j--) {

            for (Integer n: bucket.get(j)) {
                result[i++] = n;

                if (i == k) {
                    return result;
                }
            }

        }

        return new int[]{};
    }
}
