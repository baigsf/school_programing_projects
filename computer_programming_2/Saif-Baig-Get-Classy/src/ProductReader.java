import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
        ArrayList<Product> products = new ArrayList<>();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    products.add(new Product(data[0], data[1], data[2], Double.parseDouble(data[3])));
                }
            } catch (IOException e) { e.printStackTrace(); }

            System.out.printf("%-8s%-15s%-25s%-10s%n", "ID", "Name", "Desc", "Cost");
            System.out.println("============================================================");
            for(Product p : products) {
                System.out.printf("%-8s%-15s%-25s%-10.2f%n", p.getIdString(), p.getProdName(), p.getProdDesc(), p.getProdCost());
            }
        }
    }
}