/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.Server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author root
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BrugerStatusTest.class, ForbindelsesStyringTest.class, ServerTest.class, ServerLogikTest.class, ThreadsManTest.class, dbConnectionTest.class})
public class ServerSuite {

    /**
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
    }
    
}