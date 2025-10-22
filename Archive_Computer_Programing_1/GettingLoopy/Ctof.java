import java.util.Scanner;

public class Ctof {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Please enter a number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next(); // consume the invalid input
                System.out.print("Please enter a number: ");
            }
            number = scanner.nextInt();
        } while (number <= 0);

        System.out.println("You entered: " + number);
    }
}

