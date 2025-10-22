import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = SafeInput.getRangedInt(scanner, "Enter the year of your birth (1950-2015): ", 1950, 2015);


        int month = SafeInput.getRangedInt(scanner, "Enter the month of your birth (1-12): ", 1, 12);


        int maxDay;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;
            case 2:
                maxDay = 29;
                break;
            default:
                maxDay = 31;
                break;
        }
        int day = SafeInput.getRangedInt(scanner, "Enter the day of your birth (1-" + maxDay + "): ", 1, maxDay);

        // Input hour of birth (1-24)
        int hour = SafeInput.getRangedInt(scanner, "Enter the hour of your birth (1-24): ", 1, 24);

        // Input minute of birth (1-59)
        int minute = SafeInput.getRangedInt(scanner, "Enter the minute of your birth (1-59): ", 1, 59);

        System.out.println("Your birth date and time: " + month + "/" + day + "/" + year + " " + hour + ":" + minute);

        scanner.close();
    }
}
