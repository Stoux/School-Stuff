/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import boundary.FileSelector;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 * Manager voor het wegschrijven/ophalen van bestanden
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public class IOManager {
    
    /**
     * Schrijf een {@link VormVerzameling} weg naar de hardeschijf
     * @param vV De verzamling
     * @return gelukt
     */
    public static boolean saveVormVerzameling(VormVerzameling vV) {
        try {
            FileSelector fileSelector = new FileSelector();
            if (!fileSelector.showSaveDialog()) return false;
            FileOutputStream fos = new FileOutputStream(fileSelector.getSelecteerdeFile());
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(vV);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Het opslaan is mislukt!", "Mislukt", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Laad een {@link VormVerzameling} van de harde schijf
     * @return de VormVerzameling of null als er niks gevonden is
     */
    public static VormVerzameling laadVormVerzameling() {
        try {
            FileSelector selector = new FileSelector();
            if (!selector.showOpenDialog()) return null;
            VormVerzameling vV;
            FileInputStream fis = new FileInputStream(selector.getSelecteerdeFile());
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                vV = (VormVerzameling) ois.readObject();
            }
            return vV;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dit bestand is niet een vorm verzameling!", "Fout bestand", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
