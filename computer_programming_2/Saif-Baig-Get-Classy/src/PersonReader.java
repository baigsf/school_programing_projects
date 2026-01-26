import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
        ArrayList<Person> people = new ArrayList<>();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    // ID, First, Last, Title, YOB
                    people.add(new Person(data[1], data[2], data[0], data[3], Integer.parseInt(data[4])));
                }
            } catch (IOException e) { e.printStackTrace(); }

            System.out.printf("%-8s%-15s%-15s%-10s%-6s%n", "ID", "First", "Last", "Title", "YOB");
            System.out.println("========================================================");
            for(Person p : people) {
                System.out.printf("%-8s%-15s%-15s%-10s%-6d%n", p.getID(), p.getFirstName(), p.getLastName(), p.getTitle(), p.getYOB());
            }
        }
    }
}