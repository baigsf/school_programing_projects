import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main program that lets user pick a text file and displays short words
 */
public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            Filter filter = new ShortWordFilter();
            
            System.out.println("Short words (length < 5) from file: " + selectedFile.getName());
            System.out.println("------------------------------------------------");
            
            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    if (filter.accept(word)) {
                        System.out.println(word);
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
