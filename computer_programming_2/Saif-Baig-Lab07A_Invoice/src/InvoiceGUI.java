import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceGUI extends JFrame {
    private JTextField productNameField;
    private JTextField unitPriceField;
    private JTextField quantityField;
    private JTextArea invoiceArea;
    private Invoice invoice;

    public InvoiceGUI() {
        invoice = new Invoice();
        
        setTitle("Invoice Application");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        inputPanel.add(productNameField);
        
        inputPanel.add(new JLabel("Unit Price ($):"));
        unitPriceField = new JTextField();
        inputPanel.add(unitPriceField);
        
        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);
        
        JButton addButton = new JButton("Add Line Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLineItem();
            }
        });
        inputPanel.add(addButton);
        
        JButton clearButton = new JButton("Clear Invoice");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoice = new Invoice();
                updateInvoiceDisplay();
                productNameField.setText("");
                unitPriceField.setText("");
                quantityField.setText("");
            }
        });
        inputPanel.add(clearButton);
        
        add(inputPanel, BorderLayout.NORTH);
        
        invoiceArea = new JTextArea();
        invoiceArea.setEditable(false);
        invoiceArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        add(new JScrollPane(invoiceArea), BorderLayout.CENTER);
        
        updateInvoiceDisplay();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void addLineItem() {
        try {
            String name = productNameField.getText().trim();
            double price = Double.parseDouble(unitPriceField.getText().trim());
            int qty = Integer.parseInt(quantityField.getText().trim());
            
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a product name.");
                return;
            }
            
            Product product = new Product(name, price);
            LineItem lineItem = new LineItem(product, qty);
            invoice.addLineItem(lineItem);
            
            updateInvoiceDisplay();
            
            productNameField.setText("");
            unitPriceField.setText("");
            quantityField.setText("");
            productNameField.requestFocus();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for price and quantity.");
        }
    }
    
    private void updateInvoiceDisplay() {
        invoiceArea.setText(invoice.getInvoiceText());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InvoiceGUI();
            }
        });
    }
}
