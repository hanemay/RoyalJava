/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;

import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import royal.Client.Ture;

/**
 *
 * @author root
 */
public class ThreadsManTest {
    
    public ThreadsManTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOnlineBrugere method, of class ThreadsMan.
     */
    @Test
    public void testGetOnlineBrugere() {
        System.out.println("getOnlineBrugere");
        ThreadsMan instance = new ThreadsMan();
        int expResult = 0;
        int result = instance.getOnlineBrugere();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrugere method, of class ThreadsMan.
     */
    @Test
    public void testGetBrugere() {
        System.out.println("getBrugere");
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
     * Test of logUd method, of class ThreadsMan.
     */
    @Test
    public void testLogUd() {
        System.out.println("logUd");
        Socket socket = null;
        ThreadsMan instance = new ThreadsMan();
        instance.logUd(socket);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkForKopi method, of class ThreadsMan.
     */
    @Test
    public void testCheckForKopi() throws Exception {
        System.out.println("checkForKopi");
        String BrugerNavn = "";
        ThreadsMan instance = new ThreadsMan();
        instance.checkForKopi(BrugerNavn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBrugerSockets method, of class ThreadsMan.
     */
    @Test
    public void testSetBrugerSockets() {
        System.out.println("setBrugerSockets");
        Socket socket = null;
        ThreadsMan instance = new ThreadsMan();
        instance.setBrugerSockets(socket);
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
     * Test of tilføjBruger method, of class ThreadsMan.
     */
    @Test
    public void testTilføjBruger() {
        System.out.println("tilf\u00f8jBruger");
        String brugerNavn = "";
        ThreadsMan instance = new ThreadsMan();
        instance.tilføjBruger(brugerNavn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}