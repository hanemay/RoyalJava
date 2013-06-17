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
public class onlineClientsTest {
    
    /**
     *
     */
    public onlineClientsTest() {
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
     * Test of setTimeLoggedIn method, of class onlineClients.
     */
    @Test
    public void testSetTimeLoggedIn() {
        System.out.println("setTimeLoggedIn");
        String loggedIn = "";
        OnlineKlienter instance = new OnlineKlienter();
        instance.setTidLoggetInd(loggedIn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class onlineClients.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        OnlineKlienter instance = new OnlineKlienter();
        instance.setBrugernavn(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class onlineClients.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        OnlineKlienter instance = new OnlineKlienter();
        instance.setBrugerId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSocket method, of class onlineClients.
     */
    @Test
    public void testSetSocket() {
        System.out.println("setSocket");
        String socket = "";
        OnlineKlienter instance = new OnlineKlienter();
        instance.setSocket(socket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeLoggedIn method, of class onlineClients.
     */
    @Test
    public void testGetTimeLoggedIn() {
        System.out.println("getTimeLoggedIn");
        OnlineKlienter instance = new OnlineKlienter();
        String expResult = "";
        String result = instance.getTidLoggetInd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class onlineClients.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        OnlineKlienter instance = new OnlineKlienter();
        String expResult = "";
        String result = instance.getBrugerNavn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class onlineClients.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        OnlineKlienter instance = new OnlineKlienter();
        int expResult = 0;
        int result = instance.getBrugerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSocket method, of class onlineClients.
     */
    @Test
    public void testGetSocket() {
        System.out.println("getSocket");
        OnlineKlienter instance = new OnlineKlienter();
        String expResult = "";
        String result = instance.getSocket();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class onlineClients.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        OnlineKlienter instance = new OnlineKlienter();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}