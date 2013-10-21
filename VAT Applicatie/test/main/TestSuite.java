/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import control.IOManagerTest;
import control.VormControleTest;
import control.VormVerzameling;
import entity.VormTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Leon
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    VormTest.class,
    VormVerzameling.class,
    VormControleTest.class,
    IOManagerTest.class
    
})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Log System.out
     * @param message 
     */
    public static void _(String message) {
        System.out.println(message);
    }
}