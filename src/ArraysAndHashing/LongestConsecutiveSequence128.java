package ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        Sol128 sol = new Sol128();
        sol.longestSequenceHelper(new int[]{23, 1, 24, 25, 2, 4, 3, 22});
    }
}

class Sol128 {
    int longestSequenceHelper(int nums[]) {

        HashMap<Integer, Integer> occ = new HashMap<>();
        int max = 0;

        for (Integer n: nums) {
            occ.put(n, 0);
        }

        for (Integer key: occ.keySet()) {

            if (occ.get(key) == 0) {

                int counter = 1;
                int nextKey = key + 1;

                while (true) {

                    if (occ.containsKey(nextKey)) {
                        counter++;
                        occ.put(nextKey, 1);
                        nextKey ++;
                    } else  {
                        occ.put(key, counter);
                        break;
                    }
                }

                if (counter > max) {
                    max = counter;
                }
            }
        }

        return max;
    }

    int optimizedSol(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (Integer n: nums) {
            numSet.add(n);
        }

        int longest = 0;

        for (Integer m: numSet) {
            if (!numSet.contains(m - 1)) {
                int length = 0;
                while (numSet.contains(m + length)) {
                    length += 1;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
