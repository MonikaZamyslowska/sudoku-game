package runner;

import board.Board;
import board.BoardCreator;
import service.SudokuService;


import static service.SudokuService.*;

public class SudokuPlay {
    private BoardCreator boardCreator = new BoardCreator();
    private SudokuService sudokuService = new SudokuService();

    public void serviceValueChoice(Board board) {
        while (true) {
            board.printBoard(board.getBoard());
            String choice = sudokuService.valueChoice();
            if (choice.equals("sudoku")) {
                break;
            }
            String[] selectionString = choice.split("|");
            for (int s = 0; s < selectionString.length; s += 3) {
                int row = Integer.parseInt(selectionString[s]) - 1;
                int col = Integer.parseInt(selectionString[s + 1]) - 1;
                int number = Integer.parseInt(selectionString[+2]);
                board.getBoard()[row][col] = number;
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
            boolean playAgain = true;
            while (playAgain) {
                serviceValueChoice(board);
                board.solveSudoku(createdBoard);
                board.printBoard(createdBoard);
                if (sudokuService.playAgain()) {
                    board.setBoard(copyBoard);
                } else {
                    playAgain = false;
                }
            }
            finish = sudokuService.finishGame();
        }
    }
}
