/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Blok;
import entity.Bol;
import entity.Cilinder;
import entity.Vorm;
import javax.swing.JOptionPane;
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
    public void parseDoubleIncorrect() {
        System.out.println("Testing: parseDouble incorrect");
        String s = "LOL";
        double d = vC.parseDouble(s);
        assertEquals(d, 0, 0.01);
    }
    
    @Test
    public void isDoubleCorrect() {
        System.out.println("Testing: isGeldigeDouble() correct");
        boolean geldig = vC.isGeldigeDouble("12.24");
        assertTrue(geldig);
    }
    
    @Test
    public void isDoubleIncorrectNul() {
        System.out.println("Testing: isDouble() incorrect (Onder 0)");
        boolean geldig = vC.isGeldigeDouble("-1.12");
        assertFalse(geldig);
    }
    
    @Test
    public void isDoubleIncorrect() {
        System.out.println("Testing: isGeldigeDouble() incorrect (String)");
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
    
    @Test
    public void verwijderVorm() {
        System.out.println("Testing: verwijderVorm");
        vC.maakBlok(2, 2, 2);
        vC.maakBlok(1, 1, 1);
        assertEquals(vC.getAlleVormen().size(), 2);
        assertEquals(vC.getVorm(0).getInhoud(), 8, 0.01);
        vC.verwijderVorm(0);
        assertEquals(vC.getAlleVormen().size(), 1);
        assertEquals(vC.getVorm(0).getInhoud(), 1, 0.01);
    }
    
    @Test
    public void saveVerzameling() {
        sendJOption("Correct Save test");
        System.out.println("Testing: saveVerzameling");
        vC.maakBlok(3, 3, 3);
        vC.maakBlok(2, 2, 2);
        assertEquals(vC.getAlleVormen().size(), 2);
        assertTrue(vC.slaVormVerzamelingOp());
        vC.getAlleVormen().clear();
        assertEquals(vC.getAlleVormen().size(), 0);
        System.out.println("Testing: laadVerzameling");
        assertTrue(vC.laadVormVerzameling());
        assertEquals(vC.getAlleVormen().size(), 2);
        assertEquals(vC.getVorm(0).getInhoud(), 27, 0.01);
        assertEquals(vC.getVorm(1).getInhoud(), 8, 0.01);
    }
    
    @Test
    public void faalLaden() {
        System.out.println("Testing: laadVerzameling incorrect");
        sendJOption("Selecteer een niet Verzameling object");
        assertFalse(vC.laadVormVerzameling());
    }
    
    private void sendJOption(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}