import java.util.InputMismatchException;
import java.util.Scanner; 

public class SafeInput {
    public static int getRangedInt(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Input out of range. Please enter a value between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // clear the input buffer
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input;
    }
}

