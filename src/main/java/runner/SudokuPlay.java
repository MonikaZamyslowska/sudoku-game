package runner;

import board.Board;
import board.BoardCreator;
import service.SudokuService;


import static service.Statements.*;

public class SudokuPlay {
    private BoardCreator boardCreator = new BoardCreator();
    private SudokuService sudokuService = new SudokuService();

    public void serviceValueChoice(Board board) {
        while (true) {
            board.printBoard(board.getBoard());
            String choice = sudokuService.valueChoice();
            if (choice.equals("SUDOKU")) {
                break;
            }
            String[] strings = choice.split(",");
            int row = Integer.parseInt(strings[1]) - 1;
            int col = Integer.parseInt(strings[2]) - 1;
            int number = Integer.parseInt(strings[3]);
            board.setValue(row, col, number);
        }
    }

    public void playSudoku() {
        boolean finish = false;
        System.out.println(WELCOME_MESSAGE);
        Board board = boardCreator.createBoard();
        int[][] newBoard = board.getBoard();
        while (!finish) {
            boolean ifWant = true;
            while (ifWant) {
                serviceValueChoice(board);
                int[][] solvedBoard = board.solveSudoku(newBoard);
                board.printBoard(solvedBoard);
                finish = sudokuService.gameFinished();
            }
        }
    }
}
