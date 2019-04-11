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
    
    @Test
    public void testSwap() {
        System.out.println("---Тестируем метод swap---");
        int i = 3;
        int j = 0;
        int[] anArray = {2,5,4,7,9,16};
        boolean expResult = true;
        //класс ReturnFromSwap - вложенный, поэтому указываем полный путь
        SimpleSwap.ReturnFromSwap resultOfSwap=new SimpleSwap.ReturnFromSwap();
        boolean result = resultOfSwap.swap(i, j, anArray);
        assertEquals("Метод работает неверно!",expResult, result);
    }  
    
    @Test
    public void testSwap2() {
        System.out.println("---Тестируем метод swap---");
        int i = -3;
        int j = 0;
        int[] anArray = {2,5,4,7,9,16};
        boolean expResult = false;
        SimpleSwap.ReturnFromSwap resultOfSwap=new SimpleSwap.ReturnFromSwap();
        boolean result = resultOfSwap.swap(i, j, anArray);
        assertEquals("Метод работает неверно!",expResult, result);
    }  
    
    /*
     * проверяем, действительно ли в полученном массиве переставлены элементы
     */
    
    @Test
    public void testSwap3() {
        System.out.println("---Тестируем метод swap---");
        int i = 2;
        int j = 0;
        int[] anArray = {2,5,4,7,9,16};
        int[] expResult = {4,5,2,7,9,16};
        SimpleSwap.ReturnFromSwap resultOfSwap=new SimpleSwap.ReturnFromSwap();
        resultOfSwap.swap(i, j, anArray);
        assertArrayEquals("Метод работает неверно!",expResult, anArray);
    }  
}
