import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() {
        person = new Person("Bilbo", "Baggins", "000001", "Esq.", 1960);
    }

    @Test
    public void testFormalName() { assertEquals("Esq. Bilbo Baggins", person.formalName()); }

    @Test
    public void testGetAge() { assertEquals(65, person.getAge(2025)); }

    @Test
    public void testCSVOutput() { assertEquals("000001,Bilbo,Baggins,Esq.,1960", person.toCSV()); }

    @Test
    public void testJSONOutput() {
        assertEquals("{\"ID\":\"000001\",\"firstName\":\"Bilbo\",\"lastName\":\"Baggins\",\"title\":\"Esq.\",\"YOB\":1960}", person.toJSON());
    }

    @Test
    public void testXMLOutput() {
        assertEquals("<Person><ID>000001</ID><FirstName>Bilbo</FirstName><LastName>Baggins</LastName><Title>Esq.</Title><YOB>1960</YOB></Person>", person.toXML());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYOB() { new Person("Test", "User", "000002", "Mr.", 1939); }
}