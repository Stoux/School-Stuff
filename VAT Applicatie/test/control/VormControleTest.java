/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Blok;
import entity.Bol;
import entity.Cilinder;
import entity.Vorm;
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
public class VormControleTest {
    
    private VormControle vC;
    
    public VormControleTest() {
        vC = new VormControle();
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
    public void parseDouble() {
        System.out.println("Testing: parseDouble");
        String s = "12.24";
        double d = vC.parseDouble(s);
        assertEquals(d, 12.24, 0.01);
    }
    
    @Test
    public void isDoubleCorrect() {
        System.out.println("Testing: isDouble() correct");
        boolean geldig = vC.isGeldigeDouble("12.24");
        assertTrue(geldig);
    }
    
    @Test
    public void isDoubleIncorrect() {
        System.out.println("Testing: isDouble() correct");
        boolean geldig = vC.isGeldigeDouble("LOL");
        assertFalse(geldig);
    }
    
    @Test
    public void maakBol() {
        System.out.println("Testing: maakBol");
        vC.maakBol(10);
        Vorm v = vC.getVorm(0);
        assertTrue(v instanceof Bol);
    }
    
    @Test
    public void maakBlok() {
        System.out.println("Testing: maakBlok");
        vC.maakBlok(10, 12, 19);
        Vorm v = vC.getVorm(0);
        assertTrue(v instanceof Blok);
    }
    
    @Test
    public void maakCilinder() {
        System.out.println("Testing: maakCilinder");
        vC.maakCilinder(10, 12);
        Vorm v = vC.getVorm(0);
        assertTrue(v instanceof Cilinder);
    }
    
    @Test
    public void totaleInhoud() {
        System.out.println("Testing: totaleInhoud");
        vC.maakBlok(5, 5, 5);
        vC.maakBlok(2, 2, 2);
        double d = vC.totaalInhoud();
        assertEquals(d, 133, 0.01);
    }
    
}