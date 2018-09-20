import board.Board;
import board.BoardCreator;
import resolve.SudokuSolver;

public class SudokuRunner {
    public static void main(String[] args) {
        int[][] easyBoard = {
                { 0, 2, 0, 4, 5, 6, 7, 8, 9 },
                { 4, 5, 7, 0, 8, 0, 2, 3, 6 },
                { 6, 8, 9, 2, 3, 7, 0, 4, 0 },
                { 0, 0, 5, 3, 6, 2, 9, 7, 4 },
                { 2, 7, 4, 0, 9, 0, 6, 5, 9 },
                { 3, 9, 6, 5, 7, 4, 8, 0, 0 },
                { 0, 4, 0, 6, 1, 8, 3, 9, 7 },
                { 7, 6, 1, 0, 4, 0, 5, 2, 8 },
                { 9, 3, 8, 7, 2, 5, 0, 6, 0 }
        };
        Board board = new Board(easyBoard);
        int[][] copy = board.solveSudoku(easyBoard);
        board.printBoard(copy);

    }
}
