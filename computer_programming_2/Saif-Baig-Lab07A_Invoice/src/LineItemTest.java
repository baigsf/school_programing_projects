import org.junit.Test;
import static org.junit.Assert.*;

public class LineItemTest {

    @Test
    public void testLineItemTotal() {
        Product product = new Product("Widget", 10.00);
        LineItem lineItem = new LineItem(product, 3);
        
        assertEquals(30.00, lineItem.getTotal(), 0.001);
    }

    @Test
    public void testLineItemQuantity() {
        Product product = new Product("Gadget", 5.00);
        LineItem lineItem = new LineItem(product, 2);
        
        assertEquals(2, lineItem.getQuantity());
        assertEquals(product, lineItem.getProduct());
    }
}
