/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import main.TestSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leon
 */
public class VormTest {
    
    private Vorm blok;
    private Vorm bol;
    private Vorm cilinder;
    
    public VormTest() {
        blok = new Blok(2, 2, 2);
        bol = new Bol(2);
        cilinder = new Cilinder(2, 2);
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void checkTypen() {
        TestSuite._("Testing: checkTypen");
        assertTrue(blok instanceof Blok);
        assertTrue(bol instanceof Bol);
        assertTrue(cilinder instanceof Cilinder);
    }
    
    @Test
    public void checkNamen() {
        TestSuite._("Testing: checkNamen");
        assertEquals(blok.getNaam(), "Blok");
        assertEquals(bol.getNaam(), "Bol");
        assertEquals(cilinder.getNaam(), "Cilinder");
    }
    
    @Test
    public void checkInhouden() {
        TestSuite._("Testing: checkInhouden");
        assertEquals(blok.getInhoud(), 8, 0.01);
        assertEquals(bol.getInhoud(), ((1.0 / 3.0) * 4.0) * Math.PI * Math.pow(2, 3), 0.01);
        assertEquals(cilinder.getInhoud(), Math.pow(Math.PI * 2, 2) * 2, 0.01);
    }
    
    @Test
    public void checkDimensies() {
        TestSuite._("Testing: checkDimensies");
        assertEquals(blok.getDimensies(), "Hoogte: 2.0 | Breedte: 2.0 | Lengte: 2.0");
        assertEquals(bol.getDimensies(), "Straal: 2.0");
        assertEquals(cilinder.getDimensies(), "Straal: 2.0 | Hoogte: 2.0");
    }
    
}