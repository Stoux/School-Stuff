/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Bol;
import javax.swing.JOptionPane;
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
public class IOManagerTest {
    
    private VormVerzameling vV;
    
    public IOManagerTest() {
        vV = new VormVerzameling();
        vV.voegToe(new Bol(10));
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

    @Test
    public void slaVerzamelingOp() {
        TestSuite._("Testing: slaVerzamelingOp");
        sendJOption("Save succes");
        assertTrue(IOManager.saveVormVerzameling(vV));
    }
    
    /* Niet te falen?
    @Test
    public void slaVerzamelingOpFaal() {
        TestSuite._("Testing: slaVerzamelingOpFaal");
        sendJOption("Save faal");
        assertFalse(m.saveVormVerzameling(null));
    }
    * */
    
    @Test
    public void laadVerzameling() {
        TestSuite._("Testing: laadVerzameling");
        sendJOption("Selecteer een vormverzameling bestand");
        assertNotNull(IOManager.laadVormVerzameling());
    }
    
    @Test
    public void laadVerzamelingFaal() {
        TestSuite._("Testing: laadVerzamelingFaal");
        sendJOption("Selecteer random bestand dat niet een vormverzameling is");
        assertNull(IOManager.laadVormVerzameling());
    }
    
    private void sendJOption(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}