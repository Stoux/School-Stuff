/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import boundary.HoofdFrame;
import control.VormControle;
import javax.swing.UIManager;

/**
 * Main class die het systeem opstart
 * Module: VH5I
 * Datum: 10-2013
 * @author Leon Stam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { //Probeer de Look And Feel -> Nimbus te zetten
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals("Nimbus")) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) { }
        new HoofdFrame(new VormControle());
    }
}
