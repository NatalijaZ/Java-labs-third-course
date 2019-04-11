package minlist;

import java.util.Arrays;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinListTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("---Before MinList class---");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("---After MinList class---");
    }

    /**
     * Test of commonMin method, of class MinList.
     */
    @Test
    public void testArray() {
        System.out.println("*Test of commonMin method*");
        ArrayList<Character> myBestList=new ArrayList<>(Arrays.asList('a','g','k','e','d','g'));
        MinList.commonMin(myBestList,2,5);
        ArrayList<Character> result=myBestList;
        ArrayList<Character> expResult=new ArrayList<>(Arrays.asList('a','g','d','e','k','g'));
        Assert.assertEquals("The commonMin method is uncorrect!",expResult, result);
    }
    
    @Test
    public void testMinInInterval() {
        System.out.println("*Test2 of commonMin method*");
        ArrayList<Integer> myBestList=new ArrayList<Integer>(Arrays.asList(9,7,6,-5,2,3));
        int result=MinList.commonMin(myBestList,1,4);
        int expResult=-5;
        Assert.assertEquals("The commonMin method is uncorrect!",expResult, result);
    }
}
