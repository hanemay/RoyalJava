/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

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
public class ClientTest {
    
    /**
     *
     */
    public ClientTest() {
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
     * Test of info method, of class Client.
     */
    @Test
    public void testInfo() {
        System.out.println("info");
        Client instance = new Client();
        Information expResult = null;
        Information result = instance.info();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startClient method, of class Client.
     * @throws Exception 
     */
    @Test
    public void testStartClient_0args() throws Exception {
        System.out.println("startClient");
        Client instance = new Client();
        instance.startClient();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendBesked method, of class Client.
     * @throws Exception 
     */
    @Test
    public void testSendBesked() throws Exception {
        System.out.println("sendBesked");
        String besked = "";
        Client instance = new Client();
        instance.sendBesked(besked);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startClient method, of class Client.
     * @throws Exception 
     */
    @Test
    public void testStartClient_String_String() throws Exception {
        System.out.println("startClient");
        String Login = "";
        String password = "";
        Client instance = new Client();
        instance.startClient(Login, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}