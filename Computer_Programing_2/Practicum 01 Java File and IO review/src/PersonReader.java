import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;

public class PersonReader {
    public static void main(String[] args) {
       //jf file chooser will allow you to pick a file
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();

            // print out the data into a table
            System.out.printf("%-8s %-12s %-12s %-8s %-6s%n",
                    "ID#", "Firstname", "Lastname", "Title", "YOB");
            System.out.println("======================================================");

            // reading and parsing the file
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    //split the lines for the collums
                    String[] parts = line.split(",\\s*"); // split on comma + optional spaces
                    if (parts.length == 5) {
                        System.out.printf("%-8s %-12s %-12s %-8s %-6s%n",
                                parts[0], parts[1], parts[2], parts[3], parts[4]);
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
