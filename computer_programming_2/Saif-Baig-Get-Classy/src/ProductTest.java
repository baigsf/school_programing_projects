import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("001", "Apple", "Red Apple", 1.50);
    }

    @Test
    public void testCSV() { assertEquals("001,Apple,Red Apple,1.5", product.toCSV()); }

    @Test
    public void testJSON() { assertEquals("{\"id\":\"001\",\"name\":\"Apple\",\"desc\":\"Red Apple\",\"cost\":1.50}", product.toJSON()); }

    @Test
    public void testXML() { assertEquals("<Product><ID>001</ID><Name>Apple</Name><Desc>Red Apple</Desc><Cost>1.50</Cost></Product>", product.toXML()); }
}