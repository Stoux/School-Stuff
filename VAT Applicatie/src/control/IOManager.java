/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author Leon
 */
public class IOManager {
    
    private String home;
    private String s;
    
    public IOManager() {
        s = File.separator;
        home = System.getProperty("user.home") + s + "VAT" + s;
        new File(home).mkdirs();
    }
    
    /**
     * Schrijf een {@link VormVerzameling} weg naar de hardeschijf
     * @param vV De verzamling
     * @return gelukt
     */
    public boolean saveVormVerzameling(VormVerzameling vV) {
        try {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + "/VAT/");
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.ABORT) return false;
            FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile());
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(vV);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Laad een {@link VormVerzameling} van de harde schijf
     * @return de VormVerzameling of null als er niks gevonden is
     */
    public VormVerzameling laadVormVerzameling() {
        try {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + "/VAT/");
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.ABORT) return null;
            VormVerzameling vV;
            FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile());
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                vV = (VormVerzameling) ois.readObject();
            }
            return vV;
        } catch (Exception e) {
            return null;
        }
    }
    
}
