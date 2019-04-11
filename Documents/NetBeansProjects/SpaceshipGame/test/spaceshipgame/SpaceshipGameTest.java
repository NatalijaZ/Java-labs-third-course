package spaceshipgame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceshipGameTest {
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before SpaceshipGame.class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("After SpaceshipGame.class");
    }

    /**
     * Test of averageSpeed method, of class SpaceshipGame.
     */
    @Test
    public void testAverageSpeed() {
        System.out.println("---Test of averageSpeed method---");
        double s1 = 1.0;
        double s2 = 2.0;
        double s3 = 3.0;
        double expResult = 2.0;
        double result = SpaceshipGame.averageSpeed(s1, s2, s3);
        assertEquals("The averageSpeed method is uncorrect!", expResult, result,
                0.0001);
    }

    /**
     * Test of minSpeed method, of class SpaceshipGame.
     */
    @Test
    public void testMinSpeed() {
        System.out.println("---Test of minSpeed method---");
        double s1 = 2.0;
        double s2 = 1.0;
        double s3 = 3.0;
        double expResult = 1.0;
        double result = SpaceshipGame.minSpeed(s1, s2, s3);
        assertEquals("The minSpeed method is uncorrect!",expResult, result, 
                0.0001);
    }
    
}
