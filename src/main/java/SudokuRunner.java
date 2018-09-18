import board.Board;
import board.CreateBoard;

public class SudokuRunner {
    public static void main(String[] args) {
        CreateBoard createBoard = new CreateBoard();
        Board board = createBoard.createBoard();
        board.printBoard();
    }
}
