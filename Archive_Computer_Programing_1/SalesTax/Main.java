import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the purchase price: $");

        double purchasePrice = scanner.nextDouble();
        double salesTaxRate = 0.05;
        double salesTax = purchasePrice * salesTaxRate;


        System.out.printf("purchase price: $%.2f%n", purchasePrice);
        System.out.printf("sales tax (5%%): $%.2f%n", salesTax);


        scanner.close();
    }
}
