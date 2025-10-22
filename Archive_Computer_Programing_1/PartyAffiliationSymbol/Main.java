import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your party affiliation:");
        System.out.println("D=Democrat");
        System.out.println("R=Republican");
        System.out.println("I=Independent");


        System.out.print("Enter your choice: ");
        char choice = scanner.next().toUpperCase().charAt(0); // Convert to uppercase for case-insensitivity


        String symbol;
        switch (choice) {
            case 'D':
                symbol = "Democratic-Donkey";
                break;
            case 'R':
                symbol = "Republican-Elephant";
                break;
            case 'I':
                symbol = "Independent-Person";
                break;
            default:
                symbol = "Other";
        }

        System.out.println("You get a " + symbol + ".");

        scanner.close();
    }
}
