package polindrom;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PolindromTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("---Before Polindrom class---");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("---After Polindrom class---");
    }
    
    /**
     * Test of isPolindrom method, of class Polindrom.
     */
    @Test
    public void testIsAPolindrom() {
        System.out.println("*Test of isPolindrom method*");
        String input = "gtiokoitg";
        boolean expResult = true;
        boolean result = Polindrom.isPolindrom(input);
        assertEquals("The isPolindrom method is uncorrect!",expResult, result);
    }
    
    @Test
    public void testIsNotAPolindrom() {
        System.out.println("*Test of isPolindrom method - isn't a polindrom");
        String input = "hey";
        boolean expResult = false;
        boolean result = Polindrom.isPolindrom(input);
        assertEquals("The isPolindrom method is uncorrect!",expResult, result);
    }
    
}
