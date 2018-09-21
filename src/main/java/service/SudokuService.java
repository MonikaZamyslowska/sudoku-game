package service;


import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;

import static service.Statements.*;

@Getter
@Setter
public class SudokuService {
    Scanner scanner = new Scanner(System.in);

    public int chooseNumber() {
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(EXCEPTION);
            number = 0;
        }
        if (number > 3) {
            System.out.println(EXCEPTION);
            number = 0;
        }
        return number;
    }

    public int choice() {
        int num = chooseNumber();
        while (num == 0) {
            num = chooseNumber();
        }
        return num;
    }

    public String valueChoice() {
        System.out.println(SET_VALUE);
        String choice = scanner.nextLine();
        Matcher valueMatcher = PATTERN_VALUE.matcher(choice);
        Matcher sudokuMatcher = PATTERN_SUDOKU.matcher(choice);
        while (valueMatcher.matches() || sudokuMatcher.matches()) {
            System.out.println(EXCEPTION);
            choice = scanner.nextLine();
            valueMatcher = PATTERN_VALUE.matcher(choice);
            sudokuMatcher = PATTERN_SUDOKU.matcher(choice);
        }
        return choice;
    }

    public boolean gameFinished() {
        System.out.println(FINISH_GAME);
        String isFinish = scanner.nextLine();
        return isFinish.equals("y");
    }
}
