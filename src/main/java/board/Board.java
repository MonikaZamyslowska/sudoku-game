package board;

import lombok.Getter;
import resolve.SudokuSolver;

import static service.Statements.*;

@Getter
public class Board {
    SudokuSolver sudokuSolver = new SudokuSolver();
    private int[][] board;
    private int[][] copyBoard;

    public Board(int[][] board) {
        this.board = board;
    }

    public void printBoard(int[][] board) {
        for (int row = BOARD_START_INDEX; row < MAX_VALUE; row++) {
            for (int col = BOARD_START_INDEX; col < MAX_VALUE; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public int[][] solveSudoku(int[][] board) {
        copyBoard = deepCopy(board);
        sudokuSolver.solve(copyBoard);
        return copyBoard;
    }

    public int[][] deepCopy(int[][] board) {
        int[][] copyBoard = new int[BOARD_SIZE][BOARD_SIZE];
        for (int r = BOARD_START_INDEX; r < BOARD_SIZE; r++) {
            for (int c = BOARD_START_INDEX; c < BOARD_SIZE; c++) {
                copyBoard[r][c] = board[r][c];
            }
        }
        return copyBoard;
    }
}
