import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;
public class ProductReader {
    public static void main(String[] args) {
        //jf file chooser will allow you to pick a file
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            // print out the data into a table

            System.out.printf("%-8s %-12s %-30s %-8s%n",
                    "ID#", "Name", "Description", "Cost");
            System.out.println("===================================================================");

            // reading and parsing the file
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    //split the lines for the collums
                    String[] parts = line.split(",\\s*"); // split on comma + optional spaces
                    if (parts.length == 4) {
                        System.out.printf("%-8s %-12s %-30s %-8s%n",
                                parts[0], parts[1], parts[2], parts[3]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
