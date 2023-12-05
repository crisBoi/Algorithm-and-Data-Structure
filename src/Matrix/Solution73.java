package Matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution73 {
    public static void main(String[] args) {

    }
}

class Matrix {

    public void SetToZeros(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        List<Pair> pairs = new ArrayList<Pair>();


        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    pairs.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < pairs.size(); i++) {
            for (int m = 0; m < colSize; m++) {
                if (pairs.get(i).getFirst() instanceof Integer) {
                    matrix[m][(Integer) pairs.get(i).getSecond()] = 0;
                }
            }

            for (int n = 0; n < rowSize; n++) {
                if (pairs.get(i).getSecond() instanceof Integer) {
                    matrix[(Integer) pairs.get(i).getFirst()][n] = 0;
                }
            }
        }

    }

}

class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
