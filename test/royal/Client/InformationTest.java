/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Client;

import java.net.Socket;
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
public class InformationTest {
    
    /**
     *
     */
    public InformationTest() {
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
     * Test of getClients method, of class Information.
     */
    @Test
    public void testGetClients() {
        System.out.println("getClients");
        Information instance = new Information();
        OnlineKlienter[] expResult = null;
        OnlineKlienter[] result = instance.getKlienter();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Information.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Information instance = new Information();
        String[] expResult = null;
        String[] result = instance.getBrugere();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeSockets method, of class Information.
     */
    @Test
    public void testWriteSockets() {
        System.out.println("writeSockets");
        Socket socket = null;
        Information instance = new Information();
        instance.skrivSockets(socket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkReply method, of class Information.
     */
    @Test
    public void testCheckReply() {
        System.out.println("checkReply");
        String Reply = "";
        Information instance = new Information();
        instance.checkSvar(Reply);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKlienter method, of class Information.
     */
    @Test
    public void testGetKlienter() {
        System.out.println("getKlienter");
        Information instance = new Information();
        OnlineKlienter[] expResult = null;
        OnlineKlienter[] result = instance.getKlienter();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrugere method, of class Information.
     */
    @Test
    public void testGetBrugere() {
        System.out.println("getBrugere");
        Information instance = new Information();
        String[] expResult = null;
        String[] result = instance.getBrugere();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skrivSockets method, of class Information.
     */
    @Test
    public void testSkrivSockets() {
        System.out.println("skrivSockets");
        Socket socket = null;
        Information instance = new Information();
        instance.skrivSockets(socket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkSvar method, of class Information.
     */
    @Test
    public void testCheckSvar() {
        System.out.println("checkSvar");
        String modtagetSvar = "";
        Information instance = new Information();
        instance.checkSvar(modtagetSvar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}