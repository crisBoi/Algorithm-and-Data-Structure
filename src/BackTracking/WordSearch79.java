package BackTracking;

public class WordSearch79 {
    public static void main(String[] args) {
        char[][] test1 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        int row = test1.length;
        int col = test1[0].length;

        System.out.println("row: " + row + " col: " + col);

    }
}

class Sol79 {
    int row;
    int col;

    boolean helper(char[][] board, String word) {
        row = board.length - 1;
        col = board[0].length - 1;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, String word, int row, int col, int current) {
        if (current >= word.length()) return true;
        if (row > this.row || col > this.col) return false;
        if (row < 0 || col < 0) return false;

        boolean isExist = false;
        if (board[row][col] == word.charAt(current)) {
            board[row][col] += 100;

            isExist = dfs(board, word, row + 1, col, current + 1) ||
                    dfs(board, word, row, col + 1, current + 1) ||
                    dfs(board, word, row - 1, col, current + 1) ||
                    dfs(board, word, row, col - 1, current + 1);

            board[row][col] -= 100;

        }
        return isExist;
    }
}
