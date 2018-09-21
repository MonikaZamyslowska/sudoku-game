
import service.SudokuService;

public class Application {
    public static void main(String[] args) {
        SudokuService sudokuService = new SudokuService();
        String aa = sudokuService.valueChoice();
        System.out.println(aa);
    }
}
