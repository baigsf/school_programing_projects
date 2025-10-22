import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter temperature in Celsius: ");

            if (scanner.hasNextDouble()) {
                double celsius = scanner.nextDouble();

                if (isValidTemperature(celsius)) {
                    double fahrenheit = convertToCelsiusToFahrenheit(celsius);
                    System.out.println("Equivalent temperature in Fahrenheit: " + fahrenheit);
                    break;
                } else {
                    System.out.println("Please enter a valid temperature value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }
        scanner.close();
    }
    private static boolean isValidTemperature(double celsius) {
        // You can add more specific validation if needed
        return celsius >= -273.15; // Absolute zero is -273.15°C
    }
    private static double convertToCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
