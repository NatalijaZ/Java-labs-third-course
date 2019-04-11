package min3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Min3Test {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before Min3.class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("After Min3.class");
    }

    @Test
    public void testMin() {
        System.out.println("---Тестируем метод min---");
        int a = -2;
        int b = 0;
        int c = 8;
        int expResult = -2;
        int result = Min3.min(a, b, c);
        assertEquals("Метод работает неверно!",expResult, result);
    }  
}
