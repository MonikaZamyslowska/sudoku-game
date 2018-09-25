package board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import service.SudokuService;

import static service.SudokuService.*;

@Setter
@Getter
@NoArgsConstructor
public class BoardCreator {
    SudokuService sudokuService = new SudokuService();

    public Board createBoard() {
        int[][] emptyBoard = null;

        Board board = new Board(emptyBoard);

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

        int[][] mediumBoard = {
                { 0, 9, 3, 1, 0, 5, 6, 4, 0 },
                { 7, 0, 0, 0, 0, 0, 0, 0, 5 },
                { 5, 0, 1, 2, 0, 9, 3, 0, 7 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 3 },
                { 0, 3, 6, 9, 0, 7, 5, 2, 0 },
                { 9, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 3, 0, 2, 4, 0, 8, 1, 0, 9 },
                { 6, 0, 0, 0, 0, 0, 0, 0, 4 },
                { 0, 4, 7, 3, 0, 2, 8, 5, 0 }
        };

        int[][] hardBoard = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };

        System.out.println(ASK_LEVEL);
        int chosenNum = sudokuService.choice();

        if (chosenNum == 1) {
            board = new Board(easyBoard);
        }
        if (chosenNum == 2) {
            board = new Board(mediumBoard);
        }
        if (chosenNum == 3) {
            board = new Board(hardBoard);
        }

        return board;
    }
}
