package board;

import lombok.Getter;

import static service.Statements.*;

@Getter
public class Board {
    private int[][] board;

    public Board(int[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int row = BOARD_START_INDEX; row < MAX_VALUE; row++) {
            for (int col = BOARD_START_INDEX; col < MAX_VALUE; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
