/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import royal.Server.Server;

/**
 *
 * @author root
 */
public class RoyalTrackingTest {
    
    /**
     *
     */
    public RoyalTrackingTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        Server.main(args);
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class RoyalTracking.
     * @throws Exception 
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        RoyalTracking.main(args);
    }
}