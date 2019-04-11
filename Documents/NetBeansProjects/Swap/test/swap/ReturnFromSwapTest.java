package swap;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReturnFromSwapTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before ReturnFromSwap.class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nAfter ReturnFromSwap.class");
    }

    /**
     * Test of listSwap method, of class ReturnFromSwap.
     */
    @Test
    public void testListSwap() {
        System.out.println("---Test of listSwap method---");
        ArrayList<String> myL = new ArrayList(Arrays.asList("a", "b", "c", "d"));
        int i=1;
        int j=2;
        ReturnFromSwap test1 = new ReturnFromSwap();
        boolean expResult = true;
        boolean result = test1.listSwap(myL, i, j);
        assertEquals("The listSwap method is uncorrect!",expResult, result);
    }
    @Test
    public void testListSwap1() {
        System.out.println("---Test1 of listSwap method---");
        ArrayList<String> myL = new ArrayList(Arrays.asList("a", "b", "c", "d"));
        int i=-1;
        int j=2;
        ReturnFromSwap test1 = new ReturnFromSwap();
        boolean expResult = false;
        boolean result = test1.listSwap(myL, i, j);
        assertEquals("The listSwap method is uncorrect!",expResult, result);
    }
    @Test
    public void testListSwap2() {
        System.out.println("---Test2 of listSwap method---");
        ArrayList<String> myL = new ArrayList<String>();
        int i=1;
        int j=2;
        ReturnFromSwap test1 = new ReturnFromSwap();
        boolean expResult = false;
        boolean result = test1.listSwap(myL, i, j);
        assertEquals("The listSwap method is uncorrect!",expResult, result);
    }
    @Test
    public void testListSwap3() {
        System.out.println("---Test3 of listSwap method---");
        ArrayList<String> myL = new ArrayList(Arrays.asList("a", "b", "c", "d"));
        System.out.println(myL);
        int i=1;
        int j=2;
        ArrayList<String> expResult = new ArrayList(Arrays.asList("a", "c", "b", "d"));
        ReturnFromSwap test1 = new ReturnFromSwap();
        test1.listSwap(myL,i,j);
        ArrayList<String> result = test1.getList();
        System.out.println(result);
        Assert.assertEquals(expResult, result);
    }
}
