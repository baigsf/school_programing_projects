import java.io.*;
import java.util.ArrayList;

public class ProductGenerator {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();
        ArrayList<Product> products = new ArrayList<>();

        do {
            String id = input.getNonZeroLenString("Enter ID");
            String name = input.getNonZeroLenString("Enter Product Name");
            String desc = input.getNonZeroLenString("Enter Description");
            double cost = input.getDouble("Enter Cost");
            products.add(new Product(id, name, desc, cost));
        } while (input.getYNConfirm("Add another product?"));

        String filename = input.getNonZeroLenString("Enter output filename");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Product p : products) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) { e.printStackTrace(); }
    }
}