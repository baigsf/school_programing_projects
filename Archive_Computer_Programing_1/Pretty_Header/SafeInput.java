public class SafeInput {
    public static void prettyHeader(String msg) {
        int totalStars = 60;
        int msgLength = msg.length();

        int starsBefore = (totalStars - 3 - msgLength) / 2;
        int starsAfter = totalStars - 3 - msgLength - starsBefore;


        for (int i = 0; i < totalStars; i++) {
            System.out.print("*");
        }
        System.out.println();


        System.out.print("***");
        for (int i = 0; i < starsBefore; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < starsAfter; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print the bottom row of stars
        for (int i = 0; i < totalStars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
