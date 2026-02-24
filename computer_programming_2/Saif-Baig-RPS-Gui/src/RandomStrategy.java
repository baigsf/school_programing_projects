import java.util.Random;

/**
 * A strategy that selects a random move for the computer.
 * Each move (Rock, Paper, Scissors) has an equal probability of being chosen.
 */
public class RandomStrategy implements Strategy {
    private Random rand = new Random();

    /**
     * Returns a random move from the available options.
     * @param playerMove The move the player made (not used in random strategy)
     * @return A random move: R, P, or S
     */
    @Override
    public String getMove(String playerMove) {
        String[] moves = {"R", "P", "S"};
        return moves[rand.nextInt(3)];
    }
}
