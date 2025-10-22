import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age >= 21)
        {
            System.out.println("Congratulations! You get a wristband.");
        }

        else
        {
            System.out.println("You do not qualify for a wristband.");
        }

        scanner.close();
    }
}
