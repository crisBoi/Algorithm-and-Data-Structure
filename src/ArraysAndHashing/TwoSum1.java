package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum1 {
    public static void main(String[] args) {

    }
}

class TwoSumSol {
    int[] getIndices(int[] arr, int target) {
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];

            if (valToIndex.containsKey(diff)) {
                return new int[]{ i, valToIndex.get(diff) };
            }

            valToIndex.put(arr[i], i);
        }

        return new int[]{};
    }
}
