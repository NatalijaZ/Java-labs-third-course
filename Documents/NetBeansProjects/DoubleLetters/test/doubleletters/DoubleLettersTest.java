package doubleletters;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleLettersTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("---Before DoubleLetters class---");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("---After DoubleLetters class---");
    }

    /**
     * Test of returnFromDoubleLetters method, of class DoubleLetters
     */
    @Test
    public void test1abccbaf() throws Exception {
        System.out.println("*Test of returnFromDoubleLetters method*");
        String str = "abccbaf";
        String expResult = "f";
        String result = DoubleLetters.returnFromDoubleLetters(str);
        assertEquals("The returnFromDoubleLetters method is uncorrect!", expResult, result);
    }
    
    @Test
    public void test2aabb() throws Exception {
        System.out.println("*Test of returnFromDoubleLetters method*");
        String str = "aabb";
        String expResult = "";
        String result = DoubleLetters.returnFromDoubleLetters(str);
        assertEquals("The returnFromDoubleLetters method is uncorrect!", expResult, result);
    }
    
    @Test
    public void test3abfbaf() throws Exception {
        System.out.println("*Test of returnFromDoubleLetters method*");
        String str = "abfbaf";
        String expResult = "abfbaf";
        String result = DoubleLetters.returnFromDoubleLetters(str);
        assertEquals("The returnFromDoubleLetters method is uncorrect!", expResult, result);
    }
    
    @Test
    public void test4aab() throws Exception {
        System.out.println("*Test of returnFromDoubleLetters method*");
        String str = "aab";
        String expResult = "b";
        String result = DoubleLetters.returnFromDoubleLetters(str);
        assertEquals("The returnFromDoubleLetters method is uncorrect!", expResult, result);
    }
    
    @Test (expected = ListIsTooSmallException.class)
    public void test5ExpectedException() throws Exception {
        System.out.println("*Test of returnFromDoubleLetters method*");
        String str = "a";
        DoubleLetters.returnFromDoubleLetters(str);
    }
}
