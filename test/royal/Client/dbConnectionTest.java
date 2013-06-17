/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class dbConnectionTest {
    
    /**
     *
     */
    public dbConnectionTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
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
     * Test of setTur method, of class dbConnection.
     */
    @Test
    public void testSetTur() {
        System.out.println("setTur");
        Ture tur = null;
        dbConnection instance = new dbConnection();

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connect method, of class dbConnection.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        dbConnection instance = new dbConnection();
        Connection expResult = null;
        Connection result = instance.sqlForbindelse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUfærdigeTure method, of class dbConnection.
     * @throws Exception 
     */
    @Test
    public void testSetUfærdigeTure() throws Exception {
        System.out.println("setUf\u00e6rdigeTure");
        dbConnection instance = new dbConnection();
        Ture[] expResult = null;
        Ture[] result = instance.setUfærdigeTure();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqlForbindelse method, of class dbConnection.
     */
    @Test
    public void testSqlForbindelse() {
        System.out.println("sqlForbindelse");
        dbConnection instance = new dbConnection();
        Connection expResult = null;
        Connection result = instance.sqlForbindelse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}