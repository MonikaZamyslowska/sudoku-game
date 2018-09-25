package board;

import lombok.Getter;
import lombok.Setter;
import resolve.SudokuSolver;

import static service.SudokuService.*;

@Getter
@Setter
public class Board {
    SudokuSolver sudokuSolver = new SudokuSolver();
    private int[][] board;
    private int[][] copyBoard;

    public Board(int[][] board) {
        this.board = board;
    }

    public void printBoard(int[][] board) {
        String builder = "";
        for (int row = BOARD_START_INDEX; row < MAX_VALUE; row++) {
            if (row % 3 == 0) {
                builder += "+ - - - + - - - + - - - + \n";
            }
            for (int col = BOARD_START_INDEX; col < MAX_VALUE; col++) {
                if (col % 3 == 0) {
                    builder += "| ";
                }
                builder += (board[row][col] == 0 ? "." : board[row][col]);
                builder += " ";
            }
            builder += "|\n";
        }
        builder += "+ - - - + - - - + - - - + \n";
        System.out.println(builder);
    }

    public void solveSudoku(int[][] board) {
        copyBoard = deepCopy(board);
        sudokuSolver.solve(board);
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
