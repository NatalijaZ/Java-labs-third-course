package simpleswap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleSwapTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before SimpleSwap.class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nAfter SimpleSwap.class");
    }
    
    /**
     * Test of swap method, of class SimpleSwap.
     */
    @Test
    public void testSwap() {
        System.out.println("Тестируем метод swap");
        int i = 3;
        int j = 0;
        int[] anArray = {2,5,4,7,9,16};
        boolean expResult = true;
        boolean result = SimpleSwap.swap(i, j, anArray);
        assertEquals("Метод работает неверно!",expResult, result);
    }  
}
