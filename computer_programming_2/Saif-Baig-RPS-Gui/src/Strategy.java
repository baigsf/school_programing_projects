/**
 * Defines the contract for a computer strategy in Rock Paper Scissors.
 * Implementations provide different logic for selecting a move based on
 * the player's previous move.
 */
public interface Strategy {
    /**
     * Determines the computer's move based on the player's move.
     * @param playerMove The move the player just made (R, P, or S)
     * @return The computer's chosen move (R, P, or S)
     */
    String getMove(String playerMove);
}
