import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductConstructor() {
        Product product = new Product("Widget", 9.99);
        assertEquals("Widget", product.getName());
        assertEquals(9.99, product.getUnitPrice(), 0.001);
    }

    @Test
    public void testProductSetters() {
        Product product = new Product();
        product.setName("Gadget");
        product.setUnitPrice(19.99);
        
        assertEquals("Gadget", product.getName());
        assertEquals(19.99, product.getUnitPrice(), 0.001);
    }
}
