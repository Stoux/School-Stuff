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
            new MainFrame().setVisible(true);
        } catch (Exception e) {
            
        }
    }
        
    public static void write (BufferedWriter w, String msg) throws IOException {
        w.write(msg);
        w.newLine();
    }
}
