package service;

import java.util.regex.Pattern;

public class Statements {
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
}
