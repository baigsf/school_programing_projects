import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("WelcomeCraps!");
            System.out.println("Press enter to roll the dice...");
            scanner.nextLine();

            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;

            System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("You win!");
            } else {
                int point = sum;
                System.out.println("Point is " + point);

                boolean gameOver = false;
                while (!gameOver) {
                    System.out.println("Press enter to roll again...");
                    scanner.nextLine();

                    dice1 = rollDice(random);
                    dice2 = rollDice(random);
                    int newSum = dice1 + dice2;

                    System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + newSum);

                    if (newSum == point) {
                        System.out.println("You rolled the point! You win!");
                        gameOver = true;
                    } else if (newSum == 7) {
                        System.out.println("You rolled a 7! You lose!");
                        gameOver = true;
                    }
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1; // generates a random number between 1 and 6
    }
}
