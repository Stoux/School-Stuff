/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.presentation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Leon
 */
public class _ {
    
    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    
    public static void log(String message) {
        MainFrame mf = MainFrame.getInstance();
        String logMsg = "<" + format.format(new Date()) + "> " + message;
        if (mf != null) mf.appendToLogger(logMsg);
        else System.out.println(logMsg);
    }
    
    public static MainFrame getMF() {
        return MainFrame.getInstance();
    }
    
}
