/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;

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
     * Test of getState method, of class dbConnection.
     * @throws Exception 
     */
    @Test
    public void testGetState() throws Exception {
        System.out.println("getState");
        String username = "";
        String pw = "";
        dbConnection instance = new dbConnection();
        boolean expResult = false;
        boolean result = instance.getState(username, pw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class dbConnection.
     * @throws Exception 
     */
    @Test
    public void testValidate_String_String() throws Exception {
        System.out.println("validate");
        String username = "";
        String pw = "";
        dbConnection instance = new dbConnection();
        instance.Valider(username, pw);
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
        Connection result = instance.fobind();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class dbConnection.
     */
    @Test
    public void testValidate_0args() {
        System.out.println("validate");
        dbConnection instance = new dbConnection();
        instance.validate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Valider method, of class dbConnection.
     */
    @Test
    public void testValider() throws Exception {
        System.out.println("Valider");
        String brugerNavn = "";
        String kodeord = "";
        dbConnection instance = new dbConnection();
        instance.Valider(brugerNavn, kodeord);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fobind method, of class dbConnection.
     */
    @Test
    public void testFobind() {
        System.out.println("fobind");
        dbConnection instance = new dbConnection();
        Connection expResult = null;
        Connection result = instance.fobind();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}