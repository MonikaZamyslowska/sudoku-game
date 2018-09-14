package service;

import board.Board;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class SudokuService {

    private Scanner scanner = new Scanner(System.in);

    public int chooseBoard() {
        int numberBoard;
        System.out.println(Statements.ASK_LEVEL);
        try {
            numberBoard = scanner.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println(Statements.EXCEPTION);
            numberBoard = 0;
        }
        return numberBoard;
    }
}
