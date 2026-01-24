import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] dataPoints = new int[100];
        initializeArray(dataPoints);
        displayArray(dataPoints);


        int userValue = SafeInput.getRangedInt("Enter an integer between 1 and 100: ", 1, 100);
        countOccurrences(dataPoints, userValue);
        findFirstPosition(dataPoints, userValue);


        findMinMax(dataPoints);


        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }


    public static void initializeArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1; // Random value between 1 and 100
        }
    }


    public static void displayArray(int[] arr) {
        System.out.print("DataPoints: ");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(" | ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();


        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double average = (double) sum / arr.length;
        System.out.println("Sum of dataPoints: " + sum);
        System.out.println("Average of dataPoints: " + average);
    }


    public static void countOccurrences(int[] arr, int value) {
        int count = 0;
        for (int num : arr) {
            if (num == value) {
                count++;
            }
        }
        System.out.println("Occurrences of " + value + " in dataPoints: " + count);
    }


    public static void findFirstPosition(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("The value " + value + " was found at array index " + i);
                return; // Break the loop once the value is found
            }
        }
        System.out.println("The value " + value + " was not found in dataPoints.");
    }


    public static void findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Minimum value in dataPoints: " + min);
        System.out.println("Maximum value in dataPoints: " + max);
    }


    public static double getAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }
}
