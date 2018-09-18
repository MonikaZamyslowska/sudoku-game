package service;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Scanner;

import static service.Statements.*;

@Getter
@Setter
public class SudokuService {


    public int chooseBoard() {
        int numberBoard;
        System.out.println(ASK_LEVEL);
        try {
            Scanner scanner = new Scanner(System.in);
            numberBoard = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(EXCEPTION);
            numberBoard = 0;
        }
        return numberBoard;
    }
}
