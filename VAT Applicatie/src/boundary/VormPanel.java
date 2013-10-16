/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Leon
 */
public abstract class VormPanel extends JPanel {
    
    protected boolean foutGevonden;
    protected String fout;
    
    /**
     * Probeer de vorm toe te voegen
     * @return gelukt
     */
    public abstract boolean voegToe();
    
     /**
     * Voeg een fout toe
     * @param fout De huidige fouten string
     * @param gevonden Al eerdere fout gevonden
     */
    protected void addFout(String nieuweFout) {
        if (foutGevonden) {
            fout = fout + "<br>" + "De ingevulde waarde bij " + nieuweFout + " is geen geldige waarde.";
        } else {
            foutGevonden = true;
            fout = "De ingevulde waarde bij " + nieuweFout + " is geen geldige waarde.";
        }
    }
    
    /**
     * Laat de foutmelding zien (JOptionPane)
     */
    protected void laatFoutmeldingZien() {
         JOptionPane.showMessageDialog(this, "<html>" + fout + "</html>", "Foutmelding", JOptionPane.ERROR_MESSAGE);
    }
    
}
