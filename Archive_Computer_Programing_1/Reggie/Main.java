import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ssn = SafeInput.getRegExString(scanner, "Enter your SSN (XXX-XX-XXXX): ", "^\\d{3}-\\d{2}-\\d{4}$");

        String mNumber = SafeInput.getRegExString(scanner, "Enter your UC Student M number (M#####): ", "^(M|m)\\d{5}$");

        String menuChoice = SafeInput.getRegExString(scanner, "Enter your menu choice (O, S, V, or Q): ", "^[OoSsVvQq]$");

        System.out.println("SSN: " + ssn);
        System.out.println("UC Student M number: " + mNumber);
        System.out.println("Menu choice: " + menuChoice);

        scanner.close();
    }
}
