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

/**
 *
 * @author root
 */
public class ServerLogikTest {
    
    public ServerLogikTest() {
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
     * Test of håndterInput method, of class ServerLogik.
     */
    @Test
    public void testHåndterInput() throws Exception {
        System.out.println("h\u00e5ndterInput");
        String clientForspørgsel = "";
        Socket socket = null;
        ServerLogik instance = new ServerLogik();
        String expResult = "";
        String result = instance.håndterInput(clientForspørgsel, socket);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}