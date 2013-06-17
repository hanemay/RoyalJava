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
public class OnlineKlienterTest {
    
    public OnlineKlienterTest() {
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
     * Test of setTidLoggetInd method, of class OnlineKlienter.
     */
    @Test
    public void testSetTidLoggetInd() {
        System.out.println("setTidLoggetInd");
        String tidLoggetInd = "";
        OnlineKlienter instance = new OnlineKlienter();
        instance.setTidLoggetInd(tidLoggetInd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBrugernavn method, of class OnlineKlienter.
     */
    @Test
    public void testSetBrugernavn() {
        System.out.println("setBrugernavn");
        String brugerNavn = "";
        OnlineKlienter instance = new OnlineKlienter();
        instance.setBrugernavn(brugerNavn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBrugerId method, of class OnlineKlienter.
     */
    @Test
    public void testSetBrugerId() {
        System.out.println("setBrugerId");
        int brugerId = 0;
        OnlineKlienter instance = new OnlineKlienter();
        instance.setBrugerId(brugerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSocket method, of class OnlineKlienter.
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
     * Test of getTidLoggetInd method, of class OnlineKlienter.
     */
    @Test
    public void testGetTidLoggetInd() {
        System.out.println("getTidLoggetInd");
        OnlineKlienter instance = new OnlineKlienter();
        String expResult = "";
        String result = instance.getTidLoggetInd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrugerNavn method, of class OnlineKlienter.
     */
    @Test
    public void testGetBrugerNavn() {
        System.out.println("getBrugerNavn");
        OnlineKlienter instance = new OnlineKlienter();
        String expResult = "";
        String result = instance.getBrugerNavn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrugerId method, of class OnlineKlienter.
     */
    @Test
    public void testGetBrugerId() {
        System.out.println("getBrugerId");
        OnlineKlienter instance = new OnlineKlienter();
        int expResult = 0;
        int result = instance.getBrugerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSocket method, of class OnlineKlienter.
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
     * Test of toString method, of class OnlineKlienter.
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