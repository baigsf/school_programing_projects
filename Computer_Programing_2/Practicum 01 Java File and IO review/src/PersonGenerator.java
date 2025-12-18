import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        ArrayList<String> people = new ArrayList<>();

        boolean done = false;
        do {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title");
            int yob = SafeInput.getInt(in, "Enter Year of Birth");

            String record = String.format("%s, %s, %s, %s, %d",
                    id, firstName, lastName, title, yob);

            people.add(record);

            done = !SafeInput.getYNConfirm(in, "do you want to add another person");
        } while (!done);

        String fileName = SafeInput.getNonZeroLenString(in, "enter file name to save PersonTestData.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            for (String person : people) {
                writer.write(person);
                writer.newLine(); // move to next line
            }
            System.out.println("File saved as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
