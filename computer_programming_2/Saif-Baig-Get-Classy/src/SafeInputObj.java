import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    /**
     * Default Constructor uses System.in
     */
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    /**
     * Constructor to use a specific Scanner
     * @param scanner the scanner to use
     */
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * Gets a String that is not empty
     * @param prompt the prompt to display
     * @return a non-zero length string
     */
    public String getNonZeroLenString(String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    /**
     * Gets an int within a specific range
     * @param prompt the prompt to display
     * @param low the low end of the range
     * @param high the high end of the range
     * @return a valid int within range
     */
    public int getRangedInt(String prompt, int low, int high) {
        int num;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. Enter an integer.");
                System.out.print(prompt + ": ");
                pipe.nextLine(); // clear buffer
            }
            num = pipe.nextInt();
            pipe.nextLine(); // clear newline
            if(num < low || num > high) System.out.println("Value out of range.");
        } while (num < low || num > high);
        return num;
    }

    /**
     * Gets a double value from the user
     * @param prompt the prompt to display
     * @return a valid double
     */
    public double getDouble(String prompt) {
        double num = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                num = pipe.nextDouble();
                pipe.nextLine(); // clear newline
                valid = true;
            } else {
                System.out.println("Invalid input. Enter a number.");
                pipe.nextLine(); // clear buffer
            }
        } while (!valid);
        return num;
    }

    /**
     * Gets a Yes or No confirmation
     * @param prompt the prompt to display
     * @return true for Yes, false for No
     */
    public boolean getYNConfirm(String prompt) {
        String input;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim();
            if (input.equalsIgnoreCase("Y")) return true;
            if (input.equalsIgnoreCase("N")) return false;
            System.out.println("Invalid input. Enter Y or N.");
        } while (true);
    }
}