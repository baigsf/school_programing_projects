import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();

        boolean done = false;
        do {
            String id = SafeInput.getNonZeroLenString(in, "enter product ID");
            String name = SafeInput.getNonZeroLenString(in, "enter Product name");
            String description = SafeInput.getNonZeroLenString(in, "enter Product description");
            double cost = SafeInput.getDouble(in, "enter product cost");

            String record = String.format("%s, %s, %s, %.2f",
                    id, name, description, cost);

            products.add(record);

            done = !SafeInput.getYNConfirm(in, "Do you want to add another product?");
        } while (!done);

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save as ProductTestData.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            for (String product : products) {
                writer.write(product);
                writer.newLine(); // move to next line
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
