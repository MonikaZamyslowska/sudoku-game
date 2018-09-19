import board.Board;
import board.BoardCreator;

public class SudokuRunner {
    public static void main(String[] args) {
        BoardCreator createBoard = new BoardCreator();
        Board board = createBoard.createBoard();
        board.printBoard();
    }
}
