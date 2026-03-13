import java.util.ArrayList;

public class Invoice {
    private ArrayList<LineItem> lineItems;

    public Invoice() {
        lineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (LineItem item : lineItems) {
            total += item.getTotal();
        }
        return total;
    }

    public String getInvoiceText() {
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================\n");
        sb.append("             INVOICE\n");
        sb.append("=====================================\n\n");
        sb.append(String.format("%-20s %5s %10s %10s\n", "Product", "Qty", "Price", "Total"));
        sb.append("---------------------------------------\n");
        
        for (LineItem item : lineItems) {
            sb.append(String.format("%-20s %5d $%9.2f $%9.2f\n",
                item.getProduct().getName(),
                item.getQuantity(),
                item.getProduct().getUnitPrice(),
                item.getTotal()));
        }
        
        sb.append("---------------------------------------\n");
        sb.append(String.format("%-36s $%9.2f\n", "TOTAL DUE:", getTotal()));
        sb.append("=====================================\n");
        
        return sb.toString();
    }
}
