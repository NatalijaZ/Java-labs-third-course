package reversestring;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseStringTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("---Before ReverseString class---");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("---After ReverseString class---");
    }

    /**
     * Test of reverseStr method, of class ReverseString.
     */
    @Test
    public void testReverseStr() {
        System.out.println("*Test of reverseStr method*");
        String input = "abcdefg";
        String expResult = "gfedcba";
        String result = ReverseString.reverseStr(input);
        assertEquals("The reverseStr method is uncorrect!",expResult, result);
    }   
}
