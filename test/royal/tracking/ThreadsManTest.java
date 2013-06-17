/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;

import royal.Server.ThreadsMan;
import java.net.Socket;
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
public class ThreadsManTest {
    
    /**
     *
     */
    public ThreadsManTest() {
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
     * Test of setThreads method, of class ThreadsMan.
     */
    @Test
    public void testSetThreads() {
        System.out.println("setThreads");
        Server[] k = null;
        ThreadsMan instance = new ThreadsMan();
        instance.setThreads(k);
        instance.setBrugerSockets(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOnlineUsers method, of class ThreadsMan.
     */
    @Test
    public void testGetOnlineUsers() {
        System.out.println("getOnlineUsers");
        ThreadsMan instance = new ThreadsMan();
        int expResult = 0;
        int result = instance.getOnlineBrugere();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThreads method, of class ThreadsMan.
     */
    @Test
    public void testGetThreads() {
        System.out.println("getThreads");
        ThreadsMan instance = new ThreadsMan();
        Server[] expResult = null;
        Server[] result = instance.getThreads();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class ThreadsMan.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ThreadsMan instance = new ThreadsMan();
        String[] expResult = null;
        String[] result = instance.getBrugere();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSockets method, of class ThreadsMan.
     */
    @Test
    public void testGetSockets() {
        System.out.println("getSockets");
        ThreadsMan instance = new ThreadsMan();
        Socket[] expResult = null;
        Socket[] result = instance.getSockets();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeStamp method, of class ThreadsMan.
     */
    @Test
    public void testGetTimeStamp() {
        System.out.println("getTimeStamp");
        ThreadsMan instance = new ThreadsMan();
        String[] expResult = null;
        String[] result = instance.getTimeStamp();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tur method, of class ThreadsMan.
     */
    @Test
    public void testTur() {
        System.out.println("tur");
        Ture tur = null;
        ThreadsMan instance = new ThreadsMan();
        Ture expResult = null;
        Ture result = instance.tur(tur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logoff method, of class ThreadsMan.
     */
    @Test
    public void testLogoff() {
        System.out.println("logoff");
        Socket socket = null;
        ThreadsMan instance = new ThreadsMan();
        instance.logUd(socket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserSockets method, of class ThreadsMan.
     */
    @Test
    public void testSetUserSockets() {
        System.out.println("setUserSockets");
        Socket k = null;
        ThreadsMan instance = new ThreadsMan();
        instance.setBrugerSockets(k);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printSockets method, of class ThreadsMan.
     */
    @Test
    public void testPrintSockets() {
        System.out.println("printSockets");
        ThreadsMan instance = new ThreadsMan();
        instance.printSockets();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserCount method, of class ThreadsMan.
     */
    @Test
    public void testSetUserCount() {
        System.out.println("setUserCount");
        String k = "";
        ThreadsMan instance = new ThreadsMan();
        instance.tilføjBruger(k);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}