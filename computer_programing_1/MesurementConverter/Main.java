import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double meters;

        do {
            System.out.print("enter a measurement in meters: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
            meters = scanner.nextDouble();
        } while (meters < 0);

        final double METERS_TO_MILES = 0.000621371;
        final double METERS_TO_FEET = 3.28084;
        final double METERS_TO_INCHES = 39.3701;

        double miles = meters * METERS_TO_MILES;
        double feet = meters * METERS_TO_FEET;
        double inches = meters * METERS_TO_INCHES;
        System.out.println("cconversion Results:");
        System.out.println(meters + " meters is approximately:");
        System.out.println(miles + " miles");
        System.out.println(feet + " feet");
        System.out.println(inches + " inches");

        scanner.close();
    }
}
