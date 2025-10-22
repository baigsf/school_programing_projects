import java.util.Scanner;

public class SafeInput {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Example usage of getRangedInt method
        int low = 0;
        int high = 100;
        int userInput = getRangedInt(console, "Enter a number between " + low + " and " + high + ": ", low, high);
        System.out.println("User input: " + userInput);

        // Example usage of getYNConfirm method
        boolean confirmed = getYNConfirm(console, "Are you sure? (Y/N): ");
        System.out.println("Confirmed: " + confirmed);

        console.close();
    }

    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            while (!console.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid integer.");
                console.next(); // discard non-integer input
                System.out.print(prompt);
            }
            input = console.nextInt();
            if (input < low || input > high) {
                System.out.println("Input out of range! Please enter a number between " + low + " and " + high + ".");
            }
        } while (input < low || input > high);
        return input;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = console.next().toUpperCase();
            if (!input.equals("Y") && !input.equals("N")) {
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
            }
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }
}

