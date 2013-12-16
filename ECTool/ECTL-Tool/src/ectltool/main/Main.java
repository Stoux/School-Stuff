/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.main;

import ectltool.presentation.MainFrame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Leon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        File f = new File("C:\\Users\\Leon\\Documents\\GitHub\\School-Stuff\\ECTool\\ECTL-Tool\\res\\Opdracht1\\A3.txt");
        f.delete();
            try (FileWriter fw = new FileWriter(f); BufferedWriter writer = new BufferedWriter(fw)) {
                int x = 0;
                while (x < 10000) {
                    write(writer,++x + ",K. van Boxelaar,21579165,638554585,Zeebrugge,BE,5");          
                }
            }
        new MainFrame().setVisible(true);
        } catch (Exception e) {
            
        }
    }
        
    public static void write (BufferedWriter w, String msg) throws IOException {
        w.write(msg);
        w.newLine();
    }
}
