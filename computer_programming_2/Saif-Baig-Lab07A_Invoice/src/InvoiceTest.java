import org.junit.Test;
import static org.junit.Assert.*;

public class InvoiceTest {

    @Test
    public void testInvoiceTotal() {
        Invoice invoice = new Invoice();
        
        Product p1 = new Product("Widget", 10.00);
        Product p2 = new Product("Gadget", 5.00);
        
        LineItem item1 = new LineItem(p1, 2);
        LineItem item2 = new LineItem(p2, 3);
        
        invoice.addLineItem(item1);
        invoice.addLineItem(item2);
        
        assertEquals(35.00, invoice.getTotal(), 0.001);
    }

    @Test
    public void testInvoiceEmpty() {
        Invoice invoice = new Invoice();
        assertEquals(0.0, invoice.getTotal(), 0.001);
    }

    @Test
    public void testInvoiceText() {
        Invoice invoice = new Invoice();
        Product p = new Product("Test", 10.00);
        LineItem item = new LineItem(p, 1);
        invoice.addLineItem(item);
        
        String text = invoice.getInvoiceText();
        assertTrue(text.contains("Test"));
        assertTrue(text.contains("10.00"));
    }
}
