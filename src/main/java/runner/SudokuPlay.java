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
            String print = board.printBoard(board.getBoard());
            System.out.println(print);
            String choice = sudokuService.valueChoice();
            if (choice.equals("sudoku")) {
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
            boolean playAgain = true;
            while (playAgain) {
                serviceValueChoice(board);
                board.solveSudoku(createdBoard);
                String print = board.printBoard(createdBoard);
                System.out.println(print);
                String printCopy = board.printBoard(board.getCopyBoard());
                System.out.println(printCopy);
                if (sudokuService.playAgain()) {
                    board.setBoard(copyBoard);
                }
            }
            finish = sudokuService.gameFinished();
        }
    }
}
