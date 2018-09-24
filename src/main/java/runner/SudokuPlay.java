package runner;

import board.Board;
import board.BoardCreator;
import service.SudokuService;


import static service.Statements.*;

public class SudokuPlay {
    private BoardCreator boardCreator = new BoardCreator();
    private SudokuService sudokuService = new SudokuService();
    private boolean sudokuFinish = false;

    public void serviceValueChoice(Board board) {
        while (true) {
            board.printBoard(board.getBoard());
            String choice = sudokuService.valueChoice();
            if (choice.equals("sudoku")) {
                sudokuFinish = true;
                break;
            }
            String[] strings = choice.split("|");
            for (int s = 0; s < strings.length; s += 3) {
                int row = Integer.parseInt(strings[s]) - 1;
                int col = Integer.parseInt(strings[s + 1]) - 1;
                int number = Integer.parseInt(strings[+2]);
                board.setValue(row, col, number);
            }
        }
    }

    public void playSudoku() {
        boolean finish = false;
        System.out.println(WELCOME_MESSAGE);
        while (!finish) {
            Board board = boardCreator.createBoard();
            int[][] createdBoard = board.getBoard();
            int[][] copyBoard = board.deepCopy(createdBoard);
            sudokuFinish = false;
            while (!sudokuFinish) {
                serviceValueChoice(board);
            }
            board.solveSudoku(createdBoard);
            board.printBoard(copyBoard);
            board.printBoard(createdBoard);
            finish = sudokuService.gameFinished();
        }
    }
}
