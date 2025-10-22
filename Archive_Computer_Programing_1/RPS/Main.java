import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a single Scanner object for the entire application's input
        // Use try-with-resources to ensure it's closed automatically when main exits
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Pass the existing 'scanner' object to getValidMove
                char playerAMove = getValidMove("Player A", scanner);
                char playerBMove = getValidMove("Player B", scanner);

                String result = determineWinner(playerAMove, playerBMove);

                System.out.println(playerAMove + " vs " + playerBMove + ": " + result);

                if (!playAgain(scanner)) {
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        // The scanner is automatically closed here by the try-with-resources statement
    }

    // Modify getValidMove to accept a Scanner object as an argument
    private static char getValidMove(String playerName, Scanner scanner) {
        char move;

        while (true) {
            System.out.print(playerName + ", enter your move R/P/S: ");
            // Now, 'scanner' here refers to the one passed from main()
            move = Character.toLowerCase(scanner.next().charAt(0));

            if (move == 'r' || move == 'p' || move == 's') {
                break;
            } else {
                System.out.println("Invalid key. Please enter R, P, or S."); // Minor typo fix
            }
        }

        return move;
    }

    private static String determineWinner(char playerA, char playerB) {
        if (playerA == playerB) {
            return "It's a Tie!";
        } else if ((playerA == 'r' && playerB == 's') || (playerA == 'p' && playerB == 'r') || (playerA == 's' && playerB == 'p')) {
            return "Player A wins!";
        } else {
            return "Player B wins!";
        }
    }

    // This method already correctly accepts the scanner
    private static boolean playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (Y/N): ");
        char choice = Character.toLowerCase(scanner.next().charAt(0));
        return choice == 'y';
    }
}
