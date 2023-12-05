package ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoKu36 {
    public static void main(String[] args) {
        Sol36 sol = new Sol36();
        char[][] sudoku = sol.getSample(1);
        System.out.println("isvalid: " + sol.isValid(sudoku));
    }
}

class Sol36 {
    boolean isValid(char[][] sudoku) {

        for (int r = 0; r < 9; r++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char colElement = sudoku[r][c];
                char rowElement = sudoku[c][r];

                if (colElement != '.') {
                    if (colSet.contains(colElement)) {
                        return false;
                    } else {
                        colSet.add(colElement);
                    }
                }

                if (rowElement != '.') {
                    if (rowSet.contains(rowElement)) {
                        return false;
                    } else {
                        rowSet.add(rowElement);
                    }
                }
            }
        }

        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (!isValidBlock(r, c, sudoku)) {
                    System.out.println("third");
                    return false;
                }
            }
        }

        return true;
    }

    boolean isValidBlock(int row, int col, char[][] sudoku) {
        int maxRow = row + 3;
        int maxCol = col + 3;

        HashSet<Character> grid = new HashSet<>();

        for (int r = row; r < maxRow; r++) {
            for (int c = col; c < maxCol; c++) {
                if (sudoku[r][c] == '.') {
                    continue;
                }
                else if (grid.contains(sudoku[r][c])) {
                    System.out.println("row: " + r + " col: " + c);
                    return false;
                }

                grid.add(sudoku[r][c]);
            }
        }

        return true;
    }

    char[][] getSample(int i) {
        switch (i) {
            case 0:
                return new char[][] {
                        {'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};


            case 1:
                return new char[][]{
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};


            default:
                return new char[][] {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        }
    }
}
