import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneTextArea;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;
    private Random random;
    
    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        
        // Get screen dimensions and set frame to 3/4 of screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setSize(width, height);
        
        // Center the frame on screen
        setLocationRelativeTo(null);
        
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize random and fortunes
        random = new Random();
        initializeFortunes();
        
        // Set layout
        setLayout(new BorderLayout());
        
        // Create panels
        add(createTopPanel(), BorderLayout.NORTH);
        add(createMiddlePanel(), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will find a dollar on the ground today... and lose it immediately.");
        fortunes.add("A mysterious stranger will ask you for directions to a place that doesn't exist.");
        fortunes.add("Your code will compile on the first try... said no programmer ever.");
        fortunes.add("You will discover that your favorite snack has been discontinued. RIP.");
        fortunes.add("An exciting opportunity awaits you... in your dreams tonight.");
        fortunes.add("You will accidentally reply-all to an email and regret it instantly.");
        fortunes.add("Your plants are plotting against you. Water them now.");
        fortunes.add("A bug in your code will become a feature... eventually.");
        fortunes.add("You will spend 30 minutes looking for your glasses while wearing them.");
        fortunes.add("Your coffee will go cold before you finish it. Every. Single. Time.");
        fortunes.add("Tomorrow you will wake up 5 minutes before your alarm. Every. Time.");
        fortunes.add("Someone will ask if you've tried turning it off and on again.");
        fortunes.add("You will find the perfect meme but forget to save it.");
        fortunes.add("Your favorite show will end on a cliffhanger. Forever.");
    }
    
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        
        // Load the image icon
        ImageIcon fortuneTellerImage = new ImageIcon("ImageIcon.png");
        
        // Create label with text and icon
        JLabel titleLabel = new JLabel("Fortune Teller", fortuneTellerImage, JLabel.CENTER);
        
        // Set text position (text below the icon)
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        
        // Set font for title
        Font titleFont = new Font("Serif", Font.BOLD, 48);
        titleLabel.setFont(titleFont);
        
        topPanel.add(titleLabel, BorderLayout.CENTER);
        
        return topPanel;
    }
    
    private JPanel createMiddlePanel() {
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        
        // Create text area
        fortuneTextArea = new JTextArea();
        fortuneTextArea.setEditable(false);
        fortuneTextArea.setLineWrap(true);
        fortuneTextArea.setWrapStyleWord(true);
        
        // Set font for fortune display
        Font fortuneFont = new Font("SansSerif", Font.PLAIN, 18);
        fortuneTextArea.setFont(fortuneFont);
        
        // Create scroll pane
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        middlePanel.add(scrollPane, BorderLayout.CENTER);
        
        return middlePanel;
    }
    
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        
        // Set font for buttons
        Font buttonFont = new Font("SansSerif", Font.BOLD, 16);
        
        // Create Read My Fortune button
        JButton readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(buttonFont);
        
        // Create Quit button
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(buttonFont);
        
        // Add action listeners using Lambda expressions
        readFortuneButton.addActionListener(e -> displayRandomFortune());
        quitButton.addActionListener(e -> System.exit(0));
        
        // Add buttons to panel
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        
        return bottomPanel;
    }
    
    private void displayRandomFortune() {
        int newIndex;
        
        // Generate a random index that is different from the last one
        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex && fortunes.size() > 1);
        
        // Update last fortune index
        lastFortuneIndex = newIndex;
        
        // Append the fortune to the text area
        String fortune = fortunes.get(newIndex);
        fortuneTextArea.append(fortune + "\n\n");
        
        // Scroll to the bottom to show the latest fortune
        fortuneTextArea.setCaretPosition(fortuneTextArea.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure GUI is created on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
        });
    }
}