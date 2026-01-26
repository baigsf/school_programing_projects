import java.io.*;
import java.util.ArrayList;

public class PersonGenerator {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();
        ArrayList<Person> people = new ArrayList<>();

        do {
            String id = input.getNonZeroLenString("Enter ID");
            String firstName = input.getNonZeroLenString("Enter First Name");
            String lastName = input.getNonZeroLenString("Enter Last Name");
            String title = input.getNonZeroLenString("Enter Title");
            int yob = input.getRangedInt("Enter Year of Birth", 1940, 2010);
            people.add(new Person(firstName, lastName, id, title, yob));
        } while (input.getYNConfirm("Add another person?"));

        String filename = input.getNonZeroLenString("Enter output filename");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person p : people) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) { e.printStackTrace(); }
    }
}