import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random rand = new Random();

    @Override
    public String getMove(String playerMove) {
        String[] moves = {"R", "P", "S"};
        return moves[rand.nextInt(3)];
    }
}
