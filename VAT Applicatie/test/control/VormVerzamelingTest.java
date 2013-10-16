/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Blok;
import entity.Bol;
import entity.Vorm;
import junit.framework.Assert;
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
public class VormVerzamelingTest {
    
    private VormVerzameling vV;
    
    public VormVerzamelingTest() {
        vV = new VormVerzameling();
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
    public void voegToe() {
        System.out.println("Testing: voegToe");
        Vorm v = new Bol(10);
        assertTrue(vV.getAlleVormen().isEmpty());
        vV.voegToe(v);
        assertTrue(vV.getAlleVormen().size() == 1);
    }
    
    @Test
    public void getVorm() {
        System.out.println("Testing: getVorm");
        Vorm v = new Blok(10, 10, 10);
        vV.voegToe(v);
        Assert.assertEquals(v, vV.getVorm(0));
    }
    
    @Test
    public void verwijderVorm() {
        System.out.println("Testing: verwijderVorm");
        Vorm v = new Bol(10);
        vV.voegToe(v);
        assertTrue(vV.getAlleVormen().size() == 1);
        vV.verwijderVorm(0);
        assertTrue(vV.getAlleVormen().isEmpty());
    }
    
    
}