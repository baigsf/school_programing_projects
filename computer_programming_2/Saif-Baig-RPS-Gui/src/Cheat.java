/**
 * A strategy where the computer always wins by picking the move that beats the player's move.
 * This is an "unbeatable" strategy that exploits the game's rock-paper-scissors mechanics.
 */
public class Cheat implements Strategy {
    /**
     * Returns the move that beats the player's current move.
     * Rock is beaten by Paper, Paper is beaten by Scissors, Scissors is beaten by Rock.
     * @param playerMove The move the player made (R, P, or S)
     * @return The winning move against the player's move
     */
    @Override
    public String getMove(String playerMove) {
        switch (playerMove) {
            case "R": return "P";
            case "P": return "S";
            case "S": return "R";
            default: return "R";
        }
    }
}
