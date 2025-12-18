import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double gallons = 0;
        double efficiency = 0;
        double pricePerGallon = 0;

        do {
            System.out.print("entter the number of gallons of gas in the tank: ");
            if (scanner.hasNextDouble()) {
                gallons = scanner.nextDouble();
                break;
            } else {
                System.out.println("invalid input. Please enter a numeric value.");
                scanner.next(); // Consume the invalid input
            }
        } while (true);

        do {
            System.out.print("enter the fuel efficiency in miles per gallon: ");
            if (scanner.hasNextDouble()) {
                efficiency = scanner.nextDouble();
                break;
            } else {
                System.out.println("invalid input. Please enter a numeric value.");
                scanner.next(); // Consume the invalid input
            }
        } while (true);

        do {
            System.out.print("enter the price of gas per gallon: ");
            if (scanner.hasNextDouble()) {
                pricePerGallon = scanner.nextDouble();
                break;
            } else {
                System.out.println("invalid input. Please enter a numeric value.");
                scanner.next(); // Consume the invalid input
            }
        } while (true);

        double costPer100Miles = (100 / efficiency) * pricePerGallon;

        double distance = gallons * efficiency;

        // Print the results
        System.out.println("cost per 100 miles: " + costPer100Miles);
        System.out.println("distance the car can go with the current gas: " + distance + " miles");

        scanner.close();
    }
}
