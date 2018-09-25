package service;


import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class SudokuService {
    public static int MIN_VALUE = 1;
    public static int MAX_VALUE = 9;
    public static int EMPTY = 0;
    public static int SUBSECTION_SIZE = 3;
    public static int BOARD_START_INDEX = 0;
    public static int BOARD_SIZE = 9;
    public static String WELCOME_MESSAGE = "WELCOME TO SUDOKU :)";
    public static String ASK_LEVEL = "Choose Level: \n EASY -> 1 \n MEDIUM -> 2 \n HARD -> 3";
    public static String SET_VALUE = "Enter filed to set and value (column row value) or enter \"SUDOKU\" " +
            "if you wont to solve Sudoku. ";
    public static String PLAY_AGAIN = "Do You want to play again? \n If yes -> \"y\" \n If no -> anything ;)";
    public static String FINISH_GAME = "Do you want to finish game? \n If yes -> \"y\" \n If no -> anything ;)";
    public static Pattern PATTERN_VALUE = Pattern.compile("^([1-9],[1-9],[1-9],?)+?$");
    public static Pattern PATTERN_SUDOKU = Pattern.compile("^SUDOKU$");
    public static String EXCEPTION = "Your answer is wrong, please choose again";

    Scanner scanner = new Scanner(System.in);

    public int chooseNumber() {
        int number;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(EXCEPTION);
            number = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
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

    public boolean playAgain() {
        System.out.println(PLAY_AGAIN);
        String playAgain = scanner.nextLine();
        return playAgain.equals("y");
    }

    public boolean finishGame() {
        System.out.println(FINISH_GAME);
        String isFinish = scanner.nextLine();
        return isFinish.equals("y");
    }
}
