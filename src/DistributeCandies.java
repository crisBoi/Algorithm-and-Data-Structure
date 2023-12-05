import java.util.Arrays;

public class DistributeCandies {
    public static void main(String[] args) {
        int[] candyType = new int[] {1, 1, 1, 2, 2, 2};
        CandySolution sol = new CandySolution();
        System.out.println("" + sol.distributeCandies(candyType));
    }
}

class CandySolution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int docAdvice = candyType.length / 2;

        int distinctCandies = 1;

        for (int i = 0; i < candyType.length; i++) {
            if (i + 1 < candyType.length) {
                if (candyType[i] != candyType[i+1]) {
                    distinctCandies++;
                }
            }
        }

        int maxCandies = Math.min(docAdvice, distinctCandies);

        return maxCandies;
    }
}
