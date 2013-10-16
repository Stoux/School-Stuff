/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

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
            File f = new File(home + s + "vormverzameling.dat");
            FileOutputStream fos = new FileOutputStream(f);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(vV);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Laad een {@link VormVerzameling} van de harde schijf
     * @return de VormVerzameling of null als er niks gevonden is
     */
    public VormVerzameling laadVormVerzameling() {
        try {
            VormVerzameling vV;
            File f = new File(home + s + "vormverzameling.dat");
            FileInputStream fis = new FileInputStream(f);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                vV = (VormVerzameling) ois.readObject();
            }
            return vV;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
    
}
