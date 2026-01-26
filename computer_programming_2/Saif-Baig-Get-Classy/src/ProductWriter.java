import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductWriter {
    public static void main(String[] args) {
        // Use the instance-based SafeInputObj you defined
        SafeInputObj input = new SafeInputObj();
        ArrayList<Product> productList = new ArrayList<>();
        boolean doContinue;

        do {
            System.out.println("\nEnter Product Details:");

            // Note: If you want auto-generated IDs, remove this line
            String idString = input.getNonZeroLenString("Enter ID");

            String prodName = input.getNonZeroLenString("Enter Product Name");
            String prodDesc = input.getNonZeroLenString("Enter Description");

            double prodCost = 0;
            boolean validCost = false;
            while(!validCost) {
                try {
                    String costStr = input.getNonZeroLenString("Enter Cost");
                    prodCost = Double.parseDouble(costStr);
                    validCost = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid cost. Please enter a number.");
                }
            }

            // Using the 4-arg constructor from the fixed Product class
            // Order: ID, Name, Desc, Cost
            Product newProduct = new Product(idString, prodName, prodDesc, prodCost);
            productList.add(newProduct);

            doContinue = input.getYNConfirm("Add another product?");

        } while (doContinue);

        String fileName = input.getNonZeroLenString("Enter output filename (without .txt)");

        // Write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
            for (Product p : productList) {
                writer.write(p.toCSV());
                writer.newLine(); // Standard cross-platform newline
            }
            System.out.println(productList.size() + " records successfully written to " + fileName + ".txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}