/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * Opent een GUI om een bestand te selecteren op de computer
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public class FileSelector {
    
        private JFileChooser fileChooser;
        
        /**
         * Constructor: File selector
         */
        public FileSelector() {
            String home = System.getProperty("user.home") + File.separator + "VAT" + File.separator;
            new File(home).mkdirs();
            fileChooser = new JFileChooser(System.getProperty("user.home") + "/VAT/");
            fileChooser.setDialogTitle("Selecteer een bestand");
        }
        
        /**
         * Laat een open dialog zien
         * @return bestand geselecteerd
         */
        public boolean showOpenDialog() {
            int result = fileChooser.showOpenDialog(null);
            if (result == 1) return false;
            else return true;
        }
        
        /**
         * Laat een save dialog zien
         * @return bestand geselecteerd
         */
        public boolean showSaveDialog() {
            int result = fileChooser.showSaveDialog(null);
            if (result == 1) return false;
            else return true;
        }
        
        /**
         * Haal het geselecteerde bestand op
         * @return het bestand
         */
        public File getSelecteerdeFile() {
            return fileChooser.getSelectedFile();
        }
        
}
