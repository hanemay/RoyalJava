/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package royal.tracking;

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
@Suite.SuiteClasses({royal.tracking.TureTest.class, royal.tracking.RoyalTrackingTest.class, royal.tracking.ThreadsManTest.class})
public class TrackingSuite {

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