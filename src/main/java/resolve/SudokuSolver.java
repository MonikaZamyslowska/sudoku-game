package resolve;

import static service.Statements.*;

public class SudokuSolver {

    public boolean solve(int[][] board) {
        return false;
    }

    public boolean isValid(int[][] board, int row, int col, int num) {
        return !containsInRow(board, row, num) && !containsInColumn(board, col, num) &&
                !containsInSubsection(board, row, col, num);
    }

    public boolean containsInRow(int[][] board, int row, int num) {
        for (int r = BOARD_START_INDEX; r < BOARD_SIZE; r++) {
            if (board[row][r] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean containsInColumn(int[][] board, int col, int num) {
        for (int c = BOARD_START_INDEX; c < BOARD_SIZE; c++) {
            if (board[c][col] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean containsInSubsection(int[][] board, int row, int col, int num) {
        int contRowStart = row - row / SUBSECTION_SIZE;
        int contRowEnd = contRowStart + SUBSECTION_SIZE;

        int contColStart = col - col / SUBSECTION_SIZE;
        int contColEnd = contColStart + SUBSECTION_SIZE;

        for (int r = contRowStart; r < contRowEnd; r++) {
            for (int c = contColStart; c < contColEnd; c++) {
                if (board[r][c]  == num) {
                    return true;
                }
            }
        }
        return false;
    }


}
