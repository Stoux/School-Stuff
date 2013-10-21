/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.VormControle;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panel voor het toevoegen van een Vorm
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public abstract class VormPanel extends JPanel {
    
    protected VormControle vormControle;
    
    protected boolean foutGevonden;
    protected String fout;

    /**
     * Constructor
     * @param vormControle De vorm controller
     */
    public VormPanel(VormControle vormControle) {
        this.vormControle = vormControle;
    }
    
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
