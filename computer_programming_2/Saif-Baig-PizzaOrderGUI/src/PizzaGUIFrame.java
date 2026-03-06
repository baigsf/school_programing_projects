import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class PizzaGUIFrame extends JFrame implements ActionListener {
    private JRadioButton rbThin, rbRegular, rbDeepDish;
    private JComboBox<String> cbSize;
    private JCheckBox cbPepperoni, cbMushrooms, cbOlives, cbSausage, cbBacon, cbExtraCheese, cbPineapple, cbGhostPeppers;
    private JTextArea taReceipt;
    private JButton btnOrder, btnClear, btnQuit;

    private static final double TAX_RATE = 0.07;
    private static final DecimalFormat df = new DecimalFormat("$#,##0.00");

    public PizzaGUIFrame() {
        setTitle("Pizza Order Form");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(700, 650));

        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 15, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel leftPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        leftPanel.add(createCrustPanel());
        leftPanel.add(createSizePanel());
        leftPanel.add(createToppingsPanel());

        JPanel rightPanel = new JPanel(new BorderLayout(0, 10));
        rightPanel.add(createReceiptPanel(), BorderLayout.CENTER);
        rightPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel, BorderLayout.CENTER);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                confirmQuit();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createCrustPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new TitledBorder("Type of Crust"));

        rbThin = new JRadioButton("Thin");
        rbRegular = new JRadioButton("Regular", true);
        rbDeepDish = new JRadioButton("Deep-dish");

        ButtonGroup crustGroup = new ButtonGroup();
        crustGroup.add(rbThin);
        crustGroup.add(rbRegular);
        crustGroup.add(rbDeepDish);

        panel.add(rbThin);
        panel.add(rbRegular);
        panel.add(rbDeepDish);

        return panel;
    }

    private JPanel createSizePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new TitledBorder("Size"));

        String[] sizes = {"Small", "Medium", "Large", "Super"};
        cbSize = new JComboBox<>(sizes);
        cbSize.setSelectedIndex(1);

        JLabel priceLabel = new JLabel("($8, $12, $16, $20)");
        panel.add(cbSize);
        panel.add(priceLabel);

        return panel;
    }

    private JPanel createToppingsPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(new TitledBorder("Toppings ($1.00 each)"));

        cbPepperoni = new JCheckBox("Pepperoni");
        cbMushrooms = new JCheckBox("Mushrooms");
        cbOlives = new JCheckBox("Black Olives");
        cbSausage = new JCheckBox("Sausage");
        cbBacon = new JCheckBox("Bacon");
        cbExtraCheese = new JCheckBox("Extra Cheese");
        cbPineapple = new JCheckBox("Pineapple");
        cbGhostPeppers = new JCheckBox("Ghost Peppers (SCARY!)");

        panel.add(cbPepperoni);
        panel.add(cbMushrooms);
        panel.add(cbOlives);
        panel.add(cbSausage);
        panel.add(cbBacon);
        panel.add(cbExtraCheese);
        panel.add(cbPineapple);
        panel.add(cbGhostPeppers);

        return panel;
    }

    private JPanel createReceiptPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("Order Receipt"));

        taReceipt = new JTextArea(18, 35);
        taReceipt.setEditable(false);
        taReceipt.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(taReceipt);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnOrder = new JButton("Order");
        btnClear = new JButton("Clear");
        btnQuit = new JButton("Quit");

        btnOrder.addActionListener(this);
        btnClear.addActionListener(this);
        btnQuit.addActionListener(this);

        panel.add(btnOrder);
        panel.add(btnClear);
        panel.add(btnQuit);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOrder) {
            processOrder();
        } else if (e.getSource() == btnClear) {
            clearForm();
        } else if (e.getSource() == btnQuit) {
            confirmQuit();
        }
    }

    private void processOrder() {
        String crust = getSelectedCrust();
        if (crust == null) {
            JOptionPane.showMessageDialog(this, "Please select a crust type.", "Order Incomplete", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int toppingCount = getSelectedToppings().size();
        if (toppingCount == 0) {
            JOptionPane.showMessageDialog(this, "Please select at least one topping.", "Order Incomplete", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double sizePrice = getSizePrice();
        String size = (String) cbSize.getSelectedItem();
        double toppingsTotal = toppingCount * 1.00;
        double subtotal = sizePrice + toppingsTotal;
        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;

        StringBuilder receipt = new StringBuilder();
        receipt.append("=========================================\n");
        receipt.append("           PIZZA ORDER RECEIPT\n");
        receipt.append("=========================================\n\n");
        receipt.append("Type of Crust: ").append(crust).append("\n");
        receipt.append("Size: ").append(size).append(" (").append(df.format(sizePrice)).append(")\n\n");
        receipt.append("Ingredients:\n");

        for (String topping : getSelectedToppings()) {
            receipt.append("  ").append(topping).append(" ...... $1.00\n");
        }

        receipt.append("\n-----------------------------------------\n");
        receipt.append("Sub-total: ........................ $").append(String.format("%-8s", df.format(subtotal))).append("\n");
        receipt.append("Tax (7%): .......................... $").append(String.format("%-8s", df.format(tax))).append("\n");
        receipt.append("=========================================\n");
        receipt.append("TOTAL: ............................ $").append(String.format("%-8s", df.format(total))).append("\n");
        receipt.append("=========================================\n");

        taReceipt.setText(receipt.toString());
    }

    private String getSelectedCrust() {
        if (rbThin.isSelected()) return "Thin";
        if (rbRegular.isSelected()) return "Regular";
        if (rbDeepDish.isSelected()) return "Deep-dish";
        return null;
    }

    private double getSizePrice() {
        int index = cbSize.getSelectedIndex();
        switch (index) {
            case 0: return 8.00;
            case 1: return 12.00;
            case 2: return 16.00;
            case 3: return 20.00;
            default: return 12.00;
        }
    }

    private java.util.List<String> getSelectedToppings() {
        java.util.List<String> toppings = new java.util.ArrayList<>();
        if (cbPepperoni.isSelected()) toppings.add("Pepperoni");
        if (cbMushrooms.isSelected()) toppings.add("Mushrooms");
        if (cbOlives.isSelected()) toppings.add("Black Olives");
        if (cbSausage.isSelected()) toppings.add("Sausage");
        if (cbBacon.isSelected()) toppings.add("Bacon");
        if (cbExtraCheese.isSelected()) toppings.add("Extra Cheese");
        if (cbPineapple.isSelected()) toppings.add("Pineapple");
        if (cbGhostPeppers.isSelected()) toppings.add("Ghost Peppers");
        return toppings;
    }

    private void clearForm() {
        rbRegular.setSelected(true);
        cbSize.setSelectedIndex(1);
        cbPepperoni.setSelected(false);
        cbMushrooms.setSelected(false);
        cbOlives.setSelected(false);
        cbSausage.setSelected(false);
        cbBacon.setSelected(false);
        cbExtraCheese.setSelected(false);
        cbPineapple.setSelected(false);
        cbGhostPeppers.setSelected(false);
        taReceipt.setText("");
    }

    private void confirmQuit() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirm Quit", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
