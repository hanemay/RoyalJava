/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import royal.Client.ClientSuite;
import royal.Server.ServerSuite;
import royal.tracking.TrackingSuite;

/**
 *
 * @author root
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ClientSuite.class, ServerSuite.class, TrackingSuite.class})
public class RoyalSuite {

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