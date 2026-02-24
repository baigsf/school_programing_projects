import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The main GUI frame for the Rock Paper Scissors game.
 * Provides buttons for player moves, displays statistics, and shows game results.
 * The computer uses various strategies to determine its moves.
 */
public class RockPaperScissorsFrame extends JFrame {
    
    private int playerWins;
    private int computerWins;
    private int ties;
    
    /**
     * Tracks how many times the player has chosen each move.
     * Used by the Least Used and Most Used strategies.
     */
    private int rockCount;
    private int paperCount;
    private int scissorsCount;
    private String lastPlayerMove;
    
    private JTextField playerWinsField;
    private JTextField computerWinsField;
    private JTextField tiesField;
    private JTextArea resultsArea;
    
    private Cheat cheatStrategy;
    private RandomStrategy randomStrategy;
    
    /**
     * Creates the game frame and initializes all UI components.
     * Sets up the title panel, buttons, statistics display, and results area.
     */
    public RockPaperScissorsFrame() {
        playerWins = 0;
        computerWins = 0;
        ties = 0;
        rockCount = 0;
        paperCount = 0;
        scissorsCount = 0;
        lastPlayerMove = null;
        
        cheatStrategy = new Cheat();
        randomStrategy = new RandomStrategy();
        
        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        add(createTitlePanel(), BorderLayout.NORTH);
        add(createButtonPanel(), BorderLayout.CENTER);
        add(createStatsPanel(), BorderLayout.EAST);
        add(createResultsPanel(), BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Rock Paper Scissors Game");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Choose Your Move"));
        
        JButton rockButton = new JButton("Rock");
        rockButton.setIcon(new ImageIcon(getClass().getResource("rock.png")));
        rockButton.addActionListener(e -> playGame("R"));
        
        JButton paperButton = new JButton("Paper");
        paperButton.setIcon(new ImageIcon(getClass().getResource("paper.png")));
        paperButton.addActionListener(e -> playGame("P"));
        
        JButton scissorsButton = new JButton("Scissors");
        scissorsButton.setIcon(new ImageIcon(getClass().getResource("scissors.png")));
        scissorsButton.addActionListener(e -> playGame("S"));
        
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));
        
        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);
        panel.add(quitButton);
        
        return panel;
    }
    
    private JPanel createStatsPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Statistics"));
        panel.setPreferredSize(new Dimension(200, 100));
        
        playerWinsField = new JTextField(10);
        playerWinsField.setEditable(false);
        
        computerWinsField = new JTextField(10);
        computerWinsField.setEditable(false);
        
        tiesField = new JTextField(10);
        tiesField.setEditable(false);
        
        panel.add(new JLabel("Player Wins:"));
        panel.add(playerWinsField);
        panel.add(new JLabel("Computer Wins:"));
        panel.add(computerWinsField);
        panel.add(new JLabel("Ties:"));
        panel.add(tiesField);
        
        updateStats();
        
        return panel;
    }
    
    private JPanel createResultsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Game Results"));
        
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void updateStats() {
        playerWinsField.setText(String.valueOf(playerWins));
        computerWinsField.setText(String.valueOf(computerWins));
        tiesField.setText(String.valueOf(ties));
    }
    
    /**
     * Handles a complete round of the game when the player makes a move.
     * Updates move counts, selects a strategy, determines the winner, and displays results.
     * @param playerMove The move chosen by the player (R, P, or S)
     */
    private void playGame(String playerMove) {
        updatePlayerMoveCount(playerMove);
        
        String strategyName = selectStrategy();
        String computerMove = getComputerMove(strategyName, playerMove);
        
        String result = determineResult(playerMove, computerMove);
        
        String displayResult = formatResult(playerMove, computerMove, result, strategyName);
        resultsArea.append(displayResult + "\n");
        
        updateStats();
        
        lastPlayerMove = playerMove;
    }
    
    private void updatePlayerMoveCount(String playerMove) {
        switch (playerMove) {
            case "R": rockCount++; break;
            case "P": paperCount++; break;
            case "S": scissorsCount++; break;
        }
    }
    
    /**
     * Randomly selects a computer strategy based on probability weights.
     * Strategies have different likelihoods: Cheat (10%), Least Used (20%),
     * Most Used (20%), Last Used (20%), Random (30%).
     * @return The name of the selected strategy
     */
    private String selectStrategy() {
        Random rand = new Random();
        int choice = rand.nextInt(100) + 1;
        
        if (choice >= 1 && choice <= 10) return "Cheat";
        else if (choice >= 11 && choice <= 30) return "Least Used";
        else if (choice >= 31 && choice <= 50) return "Most Used";
        else if (choice >= 51 && choice <= 70) return "Last Used";
        else return "Random";
    }
    
    private String getComputerMove(String strategyName, String playerMove) {
        Strategy strategy;
        
        switch (strategyName) {
            case "Cheat": strategy = cheatStrategy; break;
            case "Least Used": strategy = new LeastUsedStrategy(); break;
            case "Most Used": strategy = new MostUsedStrategy(); break;
            case "Last Used": strategy = new LastUsedStrategy(); break;
            default: strategy = randomStrategy; break;
        }
        
        return strategy.getMove(playerMove);
    }
    
    /**
     * Determines the outcome of a round by comparing player and computer moves.
     * Updates the appropriate win/tie counter.
     * @param playerMove The player's chosen move
     * @param computerMove The computer's chosen move
     * @return A string describing the result ("Tie", "Player wins", or "Computer wins")
     */
    private String determineResult(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            ties++;
            return "Tie";
        }
        
        if ((playerMove.equals("R") && computerMove.equals("S")) ||
            (playerMove.equals("P") && computerMove.equals("R")) ||
            (playerMove.equals("S") && computerMove.equals("P"))) {
            playerWins++;
            return "Player wins";
        } else {
            computerWins++;
            return "Computer wins";
        }
    }
    
    private String formatResult(String playerMove, String computerMove, String result, String strategyName) {
        String playerMoveStr = getMoveString(playerMove);
        String computerMoveStr = getMoveString(computerMove);
        String outcome;
        
        if (playerMove.equals(computerMove)) {
            outcome = "Tie";
        } else if (result.equals("Player wins")) {
            outcome = playerMoveStr + " breaks " + computerMoveStr + " (Player wins!";
        } else {
            outcome = computerMoveStr + " covers " + playerMoveStr + " (Computer Wins!";
        }
        
        return outcome + " Computer: " + strategyName + ")";
    }
    
    private String getMoveString(String move) {
        switch (move) {
            case "R": return "Rock";
            case "P": return "Paper";
            case "S": return "Scissors";
            default: return "Unknown";
        }
    }
    
    /**
     * Strategy that picks the move that beats the player's least frequently used move.
     * Exploits patterns by countering what the player rarely does.
     */
    private class LeastUsedStrategy implements Strategy {
        @Override
        public String getMove(String playerMove) {
            int minCount = Math.min(Math.min(rockCount, paperCount), scissorsCount);
            
            if (rockCount == minCount) return "P";
            else if (paperCount == minCount) return "S";
            else return "R";
        }
    }
    
    /**
     * Strategy that picks the move that beats the player's most frequently used move.
     * Anticipates the player will continue using their most common choice.
     */
    private class MostUsedStrategy implements Strategy {
        @Override
        public String getMove(String playerMove) {
            int maxCount = Math.max(Math.max(rockCount, paperCount), scissorsCount);
            
            if (rockCount == maxCount) return "P";
            else if (paperCount == maxCount) return "S";
            else return "R";
        }
    }
    
    /**
     * Strategy that picks the move that beats the player's last move.
     * If no previous move exists, falls back to random selection.
     */
    private class LastUsedStrategy implements Strategy {
        @Override
        public String getMove(String playerMove) {
            if (lastPlayerMove == null) return randomStrategy.getMove(playerMove);
            
            switch (lastPlayerMove) {
                case "R": return "P";
                case "P": return "S";
                case "S": return "R";
                default: return randomStrategy.getMove(playerMove);
            }
        }
    }
    
    /**
     * Entry point for the application. Creates and displays the game frame
     * on the Event Dispatch Thread to ensure thread safety with Swing.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissorsFrame().setVisible(true));
    }
}
