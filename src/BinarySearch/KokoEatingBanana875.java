package BinarySearch;

import java.util.Arrays;

public class KokoEatingBanana875 {
    public static void main(String[] args) {
        int[] test1 = new int[]{3, 6, 7, 11};
        int[] test2 = new int[]{805306368,805306368,805306368};
        int[] test3 = new int[]{800, 800, 800};


        Sol875 sol = new Sol875();
        System.out.println(Arrays.toString(test1));

//        for( int i = 0; i < test1.length; i++){
//            System.out.print(((test1[i] / 5) + (test1[i] % 5 == 0? 0 : 1)) + " ");
//        }
//        System.out.println("sol: " + sol.opitimized(test1, 4));
//        System.out.println("sol: " + sol.opitimized(test1, 5));
//        System.out.println("sol: " + sol.opitimized(test1, 6));
//        System.out.println("sol: " + sol.opitimized(test1, 7));
//        System.out.println("sol: " + sol.opitimized(test1, 8));
//        System.out.println("sol: " + sol.opitimized(test1, 9));
//        System.out.println("sol: " + sol.opitimized(test2, 1000000000));
        System.out.println("sol: " + sol.opitimized(test3, 1000));

    }
}

class Sol875 {
    public int bruteForce(int[] piles, int h) {
        System.out.print(h + " ");
        Arrays.sort(piles);

        if (h == piles.length) {
            return piles[piles.length - 1];
        }

        int minHrs = 1;

        while (true) {
            int totalHrs = 0;
            int i;
            for (i = 0; i < piles.length; i++) {
//                int currentTimeConsumed = (piles[i] / minHrs) + (piles[i] % minHrs == 0 ? 0 : 1);
                int currentTimeConsumed = (int) Math.ceil((double) piles[i] / minHrs);
                totalHrs += currentTimeConsumed;
                if (totalHrs <= h) {
                    if (i == piles.length - 1 && !(currentTimeConsumed * minHrs < piles[i])) {
                        return minHrs;
                    }

                } else {
                    minHrs++;
                    break;
                }
            }


            if (totalHrs <= h && i == piles.length) {
                return minHrs;
            }
        }

    }

    int opitimized(int[] piles, int h) {

        int l = 1, r = 1;

        int minK = Integer.MAX_VALUE;

        //r should be max value
        for (int i: piles) {
            r = Math.max(r, i);
        }

        while (l <= r) {
            int m = (l + r) / 2;
            int totalHours = 0;

            for (int i = 0; i < piles.length; i++) {
                totalHours += (int) Math.ceil((double) piles[i] / m);
            }

            if (totalHours <= h) {
                minK = Math.min(minK, m);
                r = m - 1;
            } else {
                l = m + 1;
            }


        }

        return minK;
    }
}
